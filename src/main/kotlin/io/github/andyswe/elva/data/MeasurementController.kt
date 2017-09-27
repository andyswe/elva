package io.github.andyswe.elva.data

/**
 * Created by andreas on 2017-09-08.
 */
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MeasurementController() {

    @Autowired  lateinit var repo : MeasurementRepository

    @GetMapping("/")  fun latestRecords() =  repo.findAll(PageRequest(0,5, Sort.Direction.DESC, "timestamp")).content



}