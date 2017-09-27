package io.github.andyswe.elva.data

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.HttpClients
import org.dom4j.Document
import org.dom4j.io.SAXReader
import java.lang.RuntimeException
import java.net.URI


/**
 * Created by andreas on 2017-09-05.
 */
class Obtainer {

    val reader = SAXReader()

    fun obtain(): Measurement {


        val httpClient = HttpClients.custom()
                .build()

        val login = RequestBuilder.post()
                .setUri(URI("http://192.168.1.226/index.htm"))
                .addParameter("passwd", "111")
                .addParameter("part", "3")
                .build()

        val loginResponse = httpClient.execute(login)
        val loginStatus = loginResponse.statusLine.statusCode

        if (200 != loginStatus) {
            throw RuntimeException("Login failed, got status ${loginStatus}")
        }


        var elDocument: Document? = null
        var vvDocument: Document? = null
        var counter = 0
        while (elDocument == null || vvDocument == null && counter < 10) {
            val document = obtainMb(httpClient)
            val mbName = document.selectSingleNode("/data/DBIpMB1_Txt").stringValue
            when (mbName) {
                "EL-01" -> elDocument = document
                "VV-01" -> vvDocument = document
            }
            counter++
        }
        val data =  Data(elDocument, vvDocument!!)
        return Parser().parse(data)
    }

    private fun obtainMb(httpClient: HttpClient): Document {




        val pageRequest = RequestBuilder.post()
                .setUri(URI("http://192.168.1.226/mb.xml"))
                .addParameter("counter", "2")
                .addHeader("Content-Type", "text/xml")
                .build()

        val page = httpClient.execute(pageRequest)
        return reader.read(page.entity.content)
    }

}