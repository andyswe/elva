package io.github.andyswe.elva.data

import java.util.*

/**
 * Created by andreas on 2017-09-06.
 */
class Parser {

        fun parse(data: Data): Measurement {


        val elCurrent = data.el.selectSingleNode("/data/DBIMB1_Value2").stringValue.toInt()
        val elTotal = data.el.selectSingleNode("/data/DBIMB1_Value1").stringValue.toInt()
        val vaTotal = data.vv.selectSingleNode("/data/DBIMB1_Value1").stringValue.toInt()

        return Measurement(
                Date(),
                elCurrent,
                elTotal,
                vaTotal

        )
    }
}