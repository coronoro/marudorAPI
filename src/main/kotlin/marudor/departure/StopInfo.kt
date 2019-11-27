package marudor.departure

data class StopInfo(
    var scheduledPlatform : String? = null,
    var platform : String,
    var scheduledTime : Long,
    var time : Long,
    var delay : Int? = null,
    var reihung : Boolean = false,
    var messages : List<Message> = emptyList(),
    var cancelled : Boolean? = null,
    var wingIds : List<String> = emptyList(),
    var hidden : Boolean? = null

)