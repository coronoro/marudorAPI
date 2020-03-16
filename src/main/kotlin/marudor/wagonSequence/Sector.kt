package marudor.wagonSequence

import com.beust.klaxon.Json
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

data class Sector(
    val positionamgleis: String? = null,
    val sektorbezeichnung: String
) {
}