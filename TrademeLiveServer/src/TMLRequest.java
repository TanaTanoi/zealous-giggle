import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import com.google.gson.Gson;

import live.trademe.ListingGroup;


public class TMLRequest {

	
	private static final String AUTHORISATION_STR =
			new String(" OAuth oauth_consumer_key=\"140AF592AB900713057339CE9CEA8260\", oauth_signature_method=\"PLAINTEXT\", oauth_signature=\"F5BB5EFFBF756109C767D92626967D19&\"");
	private  HttpURLConnection connection = null;
	
	/**
	 * Requests the 
	 * @param trademe_url - The Listing URL through the trademe API. (Latest/Hot/$1 reserve/Cool).
	 * @return - String containing the JSON string
	 */
	String requestListings(String trademe_url){
		try{
			//construct url and set authorization properties for Trademe OAuth
			URL url = new URL(trademe_url);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("Authorization", AUTHORISATION_STR);
			connection.setRequestProperty("Content-Language", "en-US");  
			//Read input from trademe
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while(br.ready()){	
				sb.append(br.readLine());
			}
			Gson gson = new Gson();
			ListingGroup l = gson.fromJson(sb.toString(), ListingGroup.class);
			System.out.println(l.toString());
			//Return result
			return sb.toString();
			
		}catch(IOException e){
			System.out.println("IOException " + e);
		}
		return"";
		
	}
	
	
}
