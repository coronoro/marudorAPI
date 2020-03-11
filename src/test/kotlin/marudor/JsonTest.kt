package marudor

import com.beust.klaxon.Klaxon
import marudor.departure.Departure
import marudor.departure.DeparturesInfo
import marudor.departure.StopInfo
import marudor.departure.TrainInfo
import marudor.hafas.TrainDetails
import marudor.station.Station
import org.junit.jupiter.api.Test
import java.io.File


internal class JsonTest {

    @Test
    fun parseStationCheck() {
        val json = JsonTest::class.java.getResource("/test/stationTest.json")
        val file = File(json.toURI())
        val parse = Klaxon().parseArray<Station>(file)
        parse?.forEach { println(it) }

    }

    @Test
    fun parseTrainDetailsCheck() {
        val json = JsonTest::class.java.getResource("/test/trainDetails.json")
        val file = File(json.toURI())
        val parse = Klaxon().parse<TrainDetails>(file)
        println(parse)

    }

    @Test
    fun parseTrainInfoCheck() {
        val json = JsonTest::class.java.getResource("/test/trainTest.json")
        val file = File(json.toURI())
        val parse = Klaxon().parse<TrainInfo>(file)
        println(parse)
    }

    @Test
    fun parseStopInfoCheck() {
        val json = JsonTest::class.java.getResource("/test/timeInfoTest.json")
        val file = File(json.toURI())
        val parse = Klaxon().parse<StopInfo>(file)
        println(parse)
    }

    @Test
    fun parseDepaturesInfoCheck() {
        val json = JsonTest::class.java.getResource("/test/test.json")
        val file = File(json.toURI())
        val parse = Klaxon().parse<DeparturesInfo>(file)
        println(parse)
    }

    @Test
    fun parseDepartureCheck() {
        val json = JsonTest::class.java.getResource("/test/departureTest.json")
        val file = File(json.toURI())
        val parse = Klaxon().parse<Departure>(file)
        println(parse)
    }

}