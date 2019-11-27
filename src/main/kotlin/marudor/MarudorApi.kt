package marudor

import com.beust.klaxon.Klaxon
import marudor.departure.DeparturesInfo
import marudor.departure.IRISDepartureType
import marudor.station.Station
import marudor.station.StationDataType
import java.net.URL
import java.net.URLEncoder

object MarudorApi : AbstractRestApi(){

    private const val V1 = "https://marudor.de/api/"
    private const val stationURL = "station/v1/search/"
    private const val irisDepartureURL = "iris/v1/abfahrten/"
    private const val wagonOrderURL = ""


    fun searchStations(searchTerm: String, type : StationDataType = StationDataType.Default, max:Int = 6): List<Station> {
        var result = listOf<Station>()
        val baseUrl = V1 + stationURL + URLEncoder.encode(searchTerm, "UTF-8")
        val parameter = "type="+type.code+"&max="+max
        val url = URL(baseUrl+ "?" + parameter)
        val representation = getRepresentation(url)

        if (representation != null){
            val parse = Klaxon().parseArray<Station>(representation.stream)
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
        val baseUrl = V1 + irisDepartureURL + URLEncoder.encode(evalId, "UTF-8")
        val parameter = "type=" + type + "&lookahead=" + lookahead + "&lookbehind=" + lookbehind
        val url = URL(baseUrl+ "?" + parameter)
        val representation = getRepresentation(url)

        if (representation != null){
            val parse = Klaxon().parse<DeparturesInfo>(representation.stream)
            if (parse != null){
                result = parse
            }
        }
        return result
    }


}