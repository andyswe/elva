package io.github.andyswe.elva.data

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by andreas on 2017-09-06.
 */
@Entity
data class Temperature(
        @Id @Temporal(TemporalType.TIMESTAMP) val timestamp: Date,
        val temp: Double,
        val sensorName: String
        ) {
}