package marudor.hafas

data class IRISMessage(
    var text: String? = null,
    var timestamp: Long? = null,
    var superseded: Boolean? = null,
    var priority: Int? = null
) {
}