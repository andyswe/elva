package io.github.andyswe.elva.data
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

/**
 * Created by andreas on 2017-09-08.
 */

interface MeasurementRepository : PagingAndSortingRepository<Measurement, Date> {

}