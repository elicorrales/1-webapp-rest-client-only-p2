
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import com.eli.calc.shape.service.rs.ShapecalcResource;
import com.eli.calc.shape.service.ws.resp.StatusCode;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestClientRESTeasyProxy {

	public static void main(String[] args) {

		String baseAddress = "http://localhost:8080/1-webapp-rest-soap-ws-p2/services/rest/";

        StatusCode code = null;
        
		try {
        code  = (StatusCode) new ResteasyClientBuilder()
        						.build()
        						.target(baseAddress)
        						//.path("/status-code-no-defined") //NOT needed
        						.proxy(ShapecalcResource.class)
        						.getStatuscodenodefined().getEntity()
        						;
        System.out.println("/status-code-no-defined, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }


		try {
        code  = new ResteasyClientBuilder()
        						.build()
        						.target(baseAddress)
        						//.path("/status-code-xml") //NOT needed
        						.proxy(ShapecalcResource.class)
        						.getStatuscodexml()
        						;
        System.out.println("/status-code-xml, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }


		try {
        code  = (StatusCode) new ResteasyClientBuilder()
        						.build()
        						.target(baseAddress)
        						.register(JacksonJsonProvider.class) //<---- had to add this
        						//.path("/status-code-json")  //NOT needed
        						.proxy(ShapecalcResource.class)
        						.getStatuscodejson().getEntity()
        						;
        System.out.println("/status-code-json, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }


	}
}
