package marudor.util

import java.net.URLEncoder

object PercentEncoder {

    fun encode(message: String): String{
        val encode = URLEncoder.encode(message, "UTF-8")
        return encode.replace("+", "%20")
    }

}