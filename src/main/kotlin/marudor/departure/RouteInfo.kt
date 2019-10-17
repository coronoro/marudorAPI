package marudor.departure

data class RouteInfo (
    var additional: Boolean? = null,
    var cancelled : Boolean? = null,
    var showVia : Boolean? = null,
    var name: String
)