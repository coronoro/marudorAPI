package marudor.wagonSequence

import com.beust.klaxon.Json

data class WagonSequence (
    var fahrtrichtung: String? = null,
    val allFahrzeuggruppe: List<VehicleGroup> = emptyList(),
    val halt: Stop,
    val liniebezeichnung: String,
    val zuggattung: String,
    val zugnummer: String,
    val serviceid: String,
    val planstarttag: String? = null,
    val fahrtid: String,
    val istplaninformation: Boolean,
    val isActuallyIC: Boolean? = null,
    val reportedZuggattung: String? = null,
    val differentDestination: Boolean,
    val differentZugnummer: Boolean,
    val scale: Double,
    val startPercentage: Int,
    val endPercentage: Int,
    val realFahrtrichtung: Boolean,
    val isRealtime: Boolean
){
}