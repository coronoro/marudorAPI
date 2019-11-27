package marudor.departure

data class TrainInfo (
    var name : String,
    var line: String? = null,
    var number: String,
    var type: String,
    var thirdParty: String? = null,
    var longDistance: Boolean? = null,
    var trainCategory: String? = null
)