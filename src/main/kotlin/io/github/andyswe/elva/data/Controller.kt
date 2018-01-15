package io.github.andyswe.elva.data

/**
 * Created by andreas on 2017-09-08.
 */
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class Controller() {

    @Autowired  lateinit var powerRepo : MeasurementRepository
    @Autowired  lateinit var temperatureRepository : TemperatureRepository

    @GetMapping("/")  fun latestRecords() =  powerRepo.findAll(PageRequest(0,5, Sort.Direction.DESC, "timestamp")).content

    @PostMapping("/temperature") fun putTemperature(@RequestBody w1ThermData: W1ThermData) : Temperature  {

        val temperature =  w1ThermData.to( Temperature(Date(), w1ThermData.temperature,w1ThermData.hwid ) ).second
        println("Saving $temperature")
        return temperatureRepository.save(temperature)
    }

    }