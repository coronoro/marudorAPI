package marudor

import org.restlet.representation.Representation
import org.restlet.resource.ClientResource
import java.net.URL

abstract class AbstractRestApi {

    companion object{
        var wait:Long  = 3000

    }

    protected fun getRepresentation(url: URL): Representation? {
        val get: Representation?
        println("get from: $url")
        val clientResource = ClientResource(url.toURI())
        val status = clientResource.status
        println(status)
        try {
            get = clientResource.get()
            Thread.sleep(wait)
        }catch (e: Exception){
            throw e
        }
        return get
    }
}