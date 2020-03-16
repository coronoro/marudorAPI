package marudor

import com.beust.klaxon.Klaxon
import marudor.departure.DeparturesInfo
import marudor.departure.IRISDepartureType
import marudor.departure.TrainInfo
import marudor.hafas.TrainDetails
import marudor.station.Station
import marudor.station.StationDataType
import marudor.util.PercentEncoder
import marudor.wagonSequence.WagonSequence
import java.net.URL
import java.net.URLEncoder
import java.util.*
import kotlin.collections.HashMap


object MarudorApi : AbstractRestApi(){

    private const val base = "https://marudor.de/api/"
    private const val stationURL = "station/v1/search/"
    private const val irisDepartureURL = "iris/v1/abfahrten/"
    private const val wagonOrderURL = "reihung/v1/wagen/"

    private const val trainDetailsURL = "hafas/v1/details/"

    fun getWagonSequence(trainNumber: String, date:String): WagonSequence?{
        var result:WagonSequence? = null
        val baseUrl = base + wagonOrderURL + PercentEncoder.encode(trainNumber) +"/"+ PercentEncoder.encode(date)
        val url = URL(baseUrl)
        val representation = getRepresentation(url)

        if (representation != null){
            while (!representation.isAvailable){
                println("waiting for availability ...")
                Thread.sleep(1_000)
            }
            val parse = Klaxon().parse<WagonSequence>(representation.stream)
            if (parse != null){
                result = parse
            }
        }
        return result
    }

    fun searchStations(searchTerm: String, type : StationDataType = StationDataType.Default, max:Int = 6): List<Station> {
        var result = listOf<Station>()
        val baseUrl = base + stationURL + PercentEncoder.encode(searchTerm)
        val parameter = "type="+type.code+"&max="+max
        val url = URL(baseUrl+ "?" + parameter)
        val representation = getRepresentation(url)

        if (representation != null){
            while (!representation.isAvailable){
                println("waiting for availability ...")
                Thread.sleep(1_000)
            }
            val parse = Klaxon().parseArray<Station>(representation.stream)
            if (parse != null){
                result = parse
            }
        }
        return result
    }

    fun getTrainDetails(train: TrainInfo, date: Date? = null, stop: String? = null): TrainDetails? {
        var msDate = ""
        if (date != null){
            val calendar = Calendar.getInstance()
            calendar.time = date
            msDate=  calendar.timeInMillis.toString()
        }

        return getTrainDetails(train.name, msDate, stop)
    }

    fun getTrainDetails(trainName: String, date: String? = null, stop: String? = null): TrainDetails? {
        var result: TrainDetails? = null
        val baseUrl = base + trainDetailsURL + PercentEncoder.encode(trainName)

        val parameterMap = HashMap<String, String>()
        if (date != null){
            parameterMap.put("date", date)
        }

        val url = URL(baseUrl+ "?" + stringifyParameters(parameterMap))
        val representation = getRepresentation(url)

        if (representation != null){
            while (!representation.isAvailable){
                println("waiting for availability ...")
                Thread.sleep(1_000)
            }
            val parse = Klaxon().parse<TrainDetails>(representation.stream)
            if (parse != null){
                result = parse
            }
        }
        return result
    }

    fun getDeparturesInfo(station: Station, type: IRISDepartureType = IRISDepartureType.Default, lookahead: Int = 120, lookbehind : Int = 0): DeparturesInfo? {
        return getDeparturesInfo(station.id, type.code, lookahead, lookbehind)
    }

    fun getDeparturesInfo(evalId : String, type: String = "default", lookahead: Int = 120, lookbehind : Int = 0): DeparturesInfo? {
        var result: DeparturesInfo? = null
        val baseUrl = base + irisDepartureURL + PercentEncoder.encode(evalId)
        val parameter = "type=" + type + "&lookahead=" + lookahead + "&lookbehind=" + lookbehind
        val url = URL(baseUrl+ "?" + parameter)
        val representation = getRepresentation(url)

        if (representation != null){
            while (!representation.isAvailable){
                println("waiting for availability ...")
                Thread.sleep(1_000)
            }
            val parse = Klaxon().parse<DeparturesInfo>(representation.stream)
            if (parse != null){
                result = parse
            }
        }
        return result
    }

    private fun stringifyParameters(parameterMap: HashMap<String, String>): String {
        var string = ""
        parameterMap.keys.forEachIndexed { index, key ->
            if (index > 0){
                string += "&"
            }
            string += key + "=" + parameterMap.get(key)
        }
        return PercentEncoder.encode(string)
    }

}