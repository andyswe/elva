package io.github.andyswe.elva.data

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component class MeasurementScheduler {

    @Autowired lateinit var powerRepo : MeasurementRepository

    @Scheduled(fixedRate = 1000* 60)  fun obtainMeasurement() {
        powerRepo.save(Obtainer().obtain())

    }
}