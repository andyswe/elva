package io.github.andyswe.elva.data

import com.fasterxml.jackson.annotation.JsonCreator

/**
 data = [{
"id": i,
"hwid": s.id,
"type": s.type_name,
"temperature": t,
"unit": unit

 {
 "hwid": "0416a4f9b4ff",
 "temperature": 21.625,
 "type": "DS18B20",
 "unit": "celsius"
 }

 */
data class W1ThermData @JsonCreator constructor (
        val hwid: String,
        val type: String,
        val temperature: Double,
        val unit: String

        )
