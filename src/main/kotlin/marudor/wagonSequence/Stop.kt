package marudor.wagonSequence

data class Stop (
    val abfahrtszeit: String? = null,
    val ankunftszeit: String? = null,
    val bahnhofsname: String,
    val evanummer: String,
    val gleisbezeichnung: String,
    val haltid: String,
    val rl100: String,
    val allSektor: List<Sector> = emptyList<Sector>()
){
}