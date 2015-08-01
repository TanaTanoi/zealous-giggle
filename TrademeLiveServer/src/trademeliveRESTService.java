
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

import com.google.gson.Gson;

import live.trademe.ListingGroup;

@Path("/")
public class trademeliveRESTService {
	
	private TMLRequest tml;
	
	private static final String LATEST_LISTINGS_STR =
			"https://api.trademe.co.nz/v1/Listings/Latest.json";
	 /**
	  * Primary request method.
	  * This method is called when the /getlisting url is requested.
	  * It will then request a JSON file from the TMLRequest class, filter it
	  * and then return a response containing the filtered JSON string.
	  * @param price - The price filter 
	  * @return - Filtered JSON file 
	  */
	@GET
	@Path("/getlisting")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getlistingRESTService(@QueryParam("price") int price) {
		tml = new TMLRequest();													//The request object
		ListingGroup output = new ListingGroup();
		String outputString = tml.requestListings(LATEST_LISTINGS_STR);
		return Response.status(200).entity(outputString).build();
	}
 
}
