import java.io.IOException;
import java.net.*;


public class TMRequest {

	private static final String LATEST_LISTINGS_STR =
			"https://api.trademe.co.nz/v1/Listings/Latest.json";
	private static final String AUTHORISATION_STR =
			new String(" OAuth oauth_consumer_key=\"140AF592AB900713057339CE9CEA8260\", oauth_signature_method=\"PLAINTEXT\", oauth_signature=\"F5BB5EFFBF756109C767D92626967D19&\"");
	private  HttpURLConnection connection = null;
	
	private   live.trademe.List requestListings(String type){
		try{
			URL url = new URL(type);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("Authorization", AUTHORISATION_STR);
		}catch(MalformedURLException e){
			
		}catch(IOException e){
			
		}
		
		return null;
	}
	
	
}
