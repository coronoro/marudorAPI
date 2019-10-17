package marudor

import com.beust.klaxon.Klaxon
import marudor.departure.DeparturesInfo
import marudor.station.Station
import marudor.station.StationType
import java.net.URL
import java.net.URLEncoder

object MarudorApi : AbstractRestApi(){

    private const val V1 = "https://marudor.de/api/"
    private const val stationEndPoint = "station/v1/search/"
    private const val irisDeparturePoint = "iris/v1/abfahrten/"



    fun findStation(searchTerm: String, type : StationType = StationType.Default, max:Int = 6): List<Station> {
        var result = listOf<Station>()
        val baseUrl = V1 + stationEndPoint + URLEncoder.encode(searchTerm, "UTF-8")
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


    fun getDeparturesInfo(evalId : String, type: String = "default", lookahead: Int = 120, lookbehind : Int = 0): DeparturesInfo? {
        var result: DeparturesInfo? = null
        val baseUrl = V1 + irisDeparturePoint + URLEncoder.encode(evalId, "UTF-8")
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