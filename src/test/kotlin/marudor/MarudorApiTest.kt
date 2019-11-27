package marudor

import marudor.departure.TrainInfo
import marudor.hafas.TrainDetails
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import marudor.station.StationDataType
import kotlin.test.assertNotEquals

internal class MarudorApiTest {

    @org.junit.jupiter.api.Test
    fun findStation() {
        val stations = MarudorApi.searchStations("Leipzig HBF")
        stations.forEach { println(it) }
        assertEquals(1, stations.size)
    }

    @org.junit.jupiter.api.Test
    fun findStationWithDS100() {
        val stations = MarudorApi.searchStations("Leipzig", StationDataType.OpenData)
        stations.forEach {
            println(it)
            assertNotNull(it.DS100)
        }
        assertEquals(6, stations.size)
    }


    @org.junit.jupiter.api.Test
    fun getDeparture() {
        val departure = MarudorApi.getDeparturesInfo("8098205")
        println(departure)
        assertNotNull(departure)
    }

    @org.junit.jupiter.api.Test
    fun getTrainDetails() {
        val trainDetails = MarudorApi.getTrainDetails("ICE 693")
        println(trainDetails)
        assertNotNull(trainDetails)

    }
}