package marudor

import org.restlet.representation.Representation
import org.restlet.resource.ClientResource
import java.net.URL
import java.util.logging.Logger

abstract class AbstractRestApi {

    companion object{
        var wait:Long  = 3000

    }

    protected fun getRepresentation(url: URL): Representation? {
        val get: Representation?
        val logger = Logger.getLogger("marudorAPI")
        logger.info("get from: $url")
        val clientResource = ClientResource(url.toURI())
        val status = clientResource.status
        try {
            get = clientResource.get()
            Thread.sleep(wait)
        }catch (e: Exception){
            throw e
        }
        return get
    }
}