package marudor.hafas

data class IRISMessage(
    var text: String,
    var timestamp: Int,
    var superseded: Boolean,
    var priority: Int
) {
}