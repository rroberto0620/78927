
package xx.mx.uv.consumo.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "saludosPortService", targetNamespace = "t4is.uv.mx/saludos", wsdlLocation = "file:/C:/Users/Roberto/Documents/TIS/78927/78927/practica07/src/main/resources/saludos.wsdl")
public class SaludosPortService
    extends Service
{

    private final static URL SALUDOSPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SALUDOSPORTSERVICE_EXCEPTION;
    private final static QName SALUDOSPORTSERVICE_QNAME = new QName("t4is.uv.mx/saludos", "saludosPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Roberto/Documents/TIS/78927/78927/practica07/src/main/resources/saludos.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SALUDOSPORTSERVICE_WSDL_LOCATION = url;
        SALUDOSPORTSERVICE_EXCEPTION = e;
    }

    public SaludosPortService() {
        super(__getWsdlLocation(), SALUDOSPORTSERVICE_QNAME);
    }

    public SaludosPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SALUDOSPORTSERVICE_QNAME, features);
    }

    public SaludosPortService(URL wsdlLocation) {
        super(wsdlLocation, SALUDOSPORTSERVICE_QNAME);
    }

    public SaludosPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SALUDOSPORTSERVICE_QNAME, features);
    }

    public SaludosPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SaludosPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SaludosPort
     */
    @WebEndpoint(name = "saludosPortSoap11")
    public SaludosPort getSaludosPortSoap11() {
        return super.getPort(new QName("t4is.uv.mx/saludos", "saludosPortSoap11"), SaludosPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SaludosPort
     */
    @WebEndpoint(name = "saludosPortSoap11")
    public SaludosPort getSaludosPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("t4is.uv.mx/saludos", "saludosPortSoap11"), SaludosPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SALUDOSPORTSERVICE_EXCEPTION!= null) {
            throw SALUDOSPORTSERVICE_EXCEPTION;
        }
        return SALUDOSPORTSERVICE_WSDL_LOCATION;
    }

}
