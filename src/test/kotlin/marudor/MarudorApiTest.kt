package marudor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import marudor.station.StationDataType

internal class MarudorApiTest {

    @org.junit.jupiter.api.Test
    fun findStation() {
        val stations = MarudorApi.searchStations("Leipzig")
        stations.forEach { println(it) }
        assertEquals(6, stations.size)
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
}