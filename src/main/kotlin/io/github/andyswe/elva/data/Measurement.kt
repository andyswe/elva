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
data class Measurement(
        @Id @Temporal(TemporalType.TIMESTAMP) val timestamp: Date,
        val power: Int,
        val elTotal: Int,
        val vaTotal: Int) {
}

