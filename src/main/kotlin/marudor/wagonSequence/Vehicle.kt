package marudor.wagonSequence

data class Vehicle(
    val allFahrzeugausstattung: List<Equipment> = emptyList<Equipment>(),
    val kategorie : String? = null,
    val fahrzeugnummer :Long,
    val orientierung:String,
    val positioningruppe :Int,
    val fahrzeugsektor: String,
    val fahrzeugtyp : String,
    val wagenordnungsnummer : String,
    val positionamhalt: VehiclePosition?,
    val status :String
) {

}
