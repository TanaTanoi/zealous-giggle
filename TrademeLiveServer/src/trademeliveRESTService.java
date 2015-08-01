
/**
 * @author Crunchify.com
 * 
 */
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/")
public class trademeliveRESTService {
 
	@GET
	@Path("/getlisting")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getlistingRESTService(@QueryParam("price") int price) {
		String result = "Test server started.. Price entered: " + price;
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
 
}
