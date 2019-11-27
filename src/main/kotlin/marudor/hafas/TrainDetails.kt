package marudor.hafas

import com.beust.klaxon.Json
import marudor.departure.Message
import marudor.departure.StopInfo
import marudor.departure.TrainInfo

data class TrainDetails(
    var type: String,
    var cancelled: Boolean? = null,
    var changeDuration: Int? = null,
    var duration: Int? = null,
    var finalDestination: String,
    var jid: String,
    var product: Product? = null,
    var raw: String? = null,
    var segmentDestination: Segment? = null,
    var segmentStart: Segment? = null,
    var stops: List<Stop>,
    var train: TrainInfo,
    var auslastung: Utilization? = null,
    @Json(ignored = true)
    var messages: List<Message> = emptyList(),
    var arrival: StopInfo? = null,
    var departure: StopInfo? = null,
    @Json(ignored = true)
    var wings: List<String> = emptyList(),
    var currentStop: Stop? = null
) {
}