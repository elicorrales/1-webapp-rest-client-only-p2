
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import com.eli.calc.shape.service.rs.ShapecalcResource;
import com.eli.calc.shape.service.ws.resp.StatusCode;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestClientRESTeasy {

	public static void main(String[] args) {

		String baseAddress = "http://localhost:8080/1-webapp-rest-soap-ws-p2/services/rest/shapecalc";

        StatusCode code = null;
        
		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-no-defined")
        						.request()
        						.get(StatusCode.class);
        System.out.println("/status-code-no-defined, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }

		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-no-defined")
        						.request()
        						.accept(MediaType.APPLICATION_XML)
        						.get(StatusCode.class);
        System.out.println("/status-code-no-defined, accept xml : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }

		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-no-defined")
        						.request()
        						.accept(MediaType.APPLICATION_JSON)
        						.get(StatusCode.class);
        System.out.println("/status-code-no-defined, accept json : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }


		
		
		
		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-xml")
        						.request()
        						.get(StatusCode.class);
        System.out.println("/status-code-xml, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }

		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-xml")
        						.request()
        						.accept(MediaType.APPLICATION_XML)
        						.get(StatusCode.class);
        System.out.println("/status-code-xml, accept xml : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }

		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-xml")
        						.request()
        						.accept(MediaType.APPLICATION_JSON)
        						.get(StatusCode.class);
        System.out.println("/status-code-xml, accept json : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }


		
		
		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-json")
        						.request()
        						.get(StatusCode.class);
        System.out.println("/status-code-json, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }

		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-json")
        						.request()
        						.accept(MediaType.APPLICATION_XML)
        						.get(StatusCode.class);
        System.out.println("/status-code-json, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }

		try {
        code  = new ResteasyClientBuilder().build().target(baseAddress).path("/status-code-json")
        						.register(JacksonJsonProvider.class) 
        						.request()
        						.accept(MediaType.APPLICATION_JSON)
        						.get(StatusCode.class);
        System.out.println("/status-code-json, no accept specified : " +code + "\n\n");
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }


	}
}
