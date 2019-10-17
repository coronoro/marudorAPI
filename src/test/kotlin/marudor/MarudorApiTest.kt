package marudor

import marudor.station.StationType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull

internal class MarudorApiTest {

    @org.junit.jupiter.api.Test
    fun findStation() {
        val stations = MarudorApi.findStation("Leipzig")
        stations.forEach { println(it) }
        assertEquals(6, stations.size)
    }

    @org.junit.jupiter.api.Test
    fun findStationWithCoordinates() {
        val stations = MarudorApi.findStation("Leipzig", StationType.DBNavigator)
        stations.forEach {
            println(it)
            assertNotNull(it.coordinate)
        }
        assertEquals(6, stations.size)
    }

    @org.junit.jupiter.api.Test
    fun findStationWithDS100() {
        val stations = MarudorApi.findStation("Leipzig", StationType.OpenData)
        stations.forEach {
            println(it)
            assertNotNull(it.DS100)
        }
        assertEquals(6, stations.size)
    }

    @org.junit.jupiter.api.Test
    fun getDeparture() {
        val departure = MarudorApi.getDeparturesInfo("8098205")
        assertNotNull(departure)


    }
}