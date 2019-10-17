package marudor.departure

import com.beust.klaxon.Json

data class DeparturesInfo(
    var lageplan: String,
    @Json(ignored = true)
    var wings : Departure? = null,
    var departures : List<Departure>,
    var lookbehind : List<Departure>
)