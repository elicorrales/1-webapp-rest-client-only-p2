import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.eli.calc.shape.service.ws.resp.StatusCode;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestClientCxfPlusJackson {

	public static void main(String[] args) {

		String baseAddress = "http://localhost:8080/1-webapp-rest-soap-ws-p2/services/rest/shapecalc";

		StatusCode code = null;
		WebClient client = null;
		int test = 0;
		
		JacksonJsonProvider jsonProv = new JacksonJsonProvider();
		List<JacksonJsonProvider> provs = new ArrayList<JacksonJsonProvider>();
		provs.add(jsonProv);

		try {
		client = WebClient.create(baseAddress).path("/status-code-no-defined");
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-no-code-defined:  " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-no-defined "+e.getMessage()+"\n\n"); }

		try {
		client = WebClient.create(baseAddress).path("/status-code-no-defined")
							.accept(MediaType.APPLICATION_XML);
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-no-code-defined, accept xml : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-no-defined:"+e.getMessage()+"\n\n"); }


		try {
		client = WebClient.create( baseAddress,provs).path("/status-code-no-defined")
							.accept(MediaType.APPLICATION_JSON);
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-no-code-defined, accept json : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-no-defined:"+e.getMessage()+"\n\n"); }



		try {
		client = WebClient.create( baseAddress,provs).path("/status-code-json");
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-code-json, no accept specified : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-json:"+e.getMessage()+"\n\n"); }



		try {
		client = WebClient.create(baseAddress).path("/status-code-json")
							.accept(MediaType.APPLICATION_XML);
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-code-json, accept xml : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-json:"+e.getMessage()+"\n\n"); }


		try {
		client = WebClient.create( baseAddress,provs).path("/status-code-json")
							.accept(MediaType.APPLICATION_JSON);
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-code-json, accept json : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-json:"+e.getMessage()+"\n\n"); }



		try {
		client = WebClient.create(baseAddress).path("/status-code-xml");
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-code-xml, no accept specified : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-xml:"+e.getMessage()+"\n\n"); }


		try {
		client = WebClient.create(baseAddress).path("/status-code-xml")
							.accept(MediaType.APPLICATION_XML);
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-code-xml, accept xml : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-xml:"+e.getMessage()+"\n\n"); }



		try {
		client = WebClient.create(baseAddress).path("/status-code-xml")
							.accept(MediaType.APPLICATION_JSON);
		code = client.get(StatusCode.class);
		System.out.println("test "+(++test)+": /status-code-xml, accept json : " + code + "\n\n");
		client.close();
		} catch (Exception e) { System.err.println("/status-code-xml:"+e.getMessage()+"\n\n"); }

	}

}
