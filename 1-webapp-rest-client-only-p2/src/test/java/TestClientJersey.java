
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


import com.eli.calc.shape.service.ws.resp.StatusCode;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestClientJersey {

	public static void main(String[] args) {

		String baseAddress = "http://localhost:8080/1-webapp-rest-soap-ws-p2/services/rest/shapecalc";

        Client client  = null;
        StatusCode code = null;
        int test = 0;
        
		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress).path("/status-code-no-defined")
        						.request()
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-no-defined, no accept specified : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress).path("/status-code-no-defined")
        						.request(MediaType.APPLICATION_XML)
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-no-defined, accept xml : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress).path("/status-code-no-defined")
        						.register(JacksonJsonProvider.class)
        						.request(MediaType.APPLICATION_JSON)
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-no-defined, accept json : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress).path("/status-code-json")
        						.register(JacksonJsonProvider.class)
        						.request()
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-json, no accept specified: " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress)
        						.path("/status-code-json")
        						.request(MediaType.APPLICATION_XML)
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-json, accept xml : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress)
        						.path("/status-code-json")
        						//.register(JacksonJsonProvider.class)
        						.request(MediaType.APPLICATION_JSON)
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-json, accept json : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-json "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress)
        						.path("/status-code-xml")
        						.request()
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-xml, no accept specified : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress)
        						.path("/status-code-xml")
        						.request(MediaType.APPLICATION_XML)
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-xml, accept xml : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }


		try {
        client  = ClientBuilder.newClient();
        code = client.target(baseAddress)
        						.path("/status-code-xml")
        						.request(MediaType.APPLICATION_JSON)
        						.get(StatusCode.class);
        System.out.println("test "+(++test)+"/status-code-xml, accept json : " +code + "\n\n");
        client.close();
		} catch (Exception e) { System.err.println("/status-code-xml "+e.getMessage()+"\n\n"); }



	}

}
