package marudor.departure

import com.beust.klaxon.Json

data class DeparturesInfo(
    @Json(ignored = true)
    var wings : Departure? = null,
    var departures : List<Departure>,
    var lookbehind : List<Departure>
)