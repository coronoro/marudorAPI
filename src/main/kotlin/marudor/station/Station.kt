package marudor.station

import marudor.Coordinate

data class Station (
    var title : String,
    val id : String,
    var favendoId : Int? = null,
    var DS100: String? = null,
    var coordinates : Coordinate? = null,
    var products : List<Product> = emptyList()

)