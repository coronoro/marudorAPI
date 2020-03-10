package marudor.departure

import marudor.station.Station

data class Departure(
    var o : String,
    var initialDeparture: Long,
    var arrival: StopInfo? = null,
    var departure : StopInfo? = null,
    var productClass : String,
    var currentStation: Station,
    var scheduledDestination : String,
    var lineNumber: String? = null,
    var id : String,
    var rawId : String,
    var mediumId: String,
    var substitute: Boolean,
    var train : TrainInfo,
    var cancelled: Boolean? = null,
    var route : List<RouteInfo>,
    var destination : String,
    var platform : String? = null,
    var scheduledPlatform: String,
    var auslastung : Boolean? = null,
    var reihung : Boolean,
    var hiddenReihung: Boolean,
    var additional : Boolean = false,
    var ref: SubstituteRef? = null,

    private var messages: Message? = null
)