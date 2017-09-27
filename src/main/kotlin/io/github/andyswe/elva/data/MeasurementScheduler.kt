package io.github.andyswe.elva.data

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component class MeasurementScheduler {

    @Autowired lateinit var repo : MeasurementRepository

    @Scheduled(fixedRate = 1000* 60)  fun obtainMeasurement() {
        repo.save(Obtainer().obtain())

    }
}