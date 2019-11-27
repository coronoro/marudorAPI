package marudor.hafas

import com.beust.klaxon.Json
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

data class Product(
    var name: String,
    var number: String,
    var icoX: Int,
    var cls: Int,
    var oprX: Int,
    var prodCtx: ProdCTX? = null,
    var addName: String,
    var nameS: String
) {
}