package marudor.hafas

import marudor.departure.StopInfo
import marudor.station.Station
import org.restlet.Message

data class Stop(
    var arrival: StopInfo? = null,
    var departure: StopInfo? = null,
    var station: Station,
    var auslastung: Utilization? = null,
    var messages: List<Message> = emptyList(),
    var additional: Boolean? = null,
    var cancelled: Boolean? = null,
    var irisMessages: List<IRISMessage> = emptyList()
    
) {
}