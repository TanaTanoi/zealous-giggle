package trademe.live.control;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.google.gson.Gson;

import live.trademe.ListingGroup;


public class TMLRequest {

	
	private static final String AUTHORISATION_STR =
			new String(" OAuth oauth_consumer_key=\"140AF592AB900713057339CE9CEA8260\", oauth_signature_method=\"PLAINTEXT\", oauth_signature=\"F5BB5EFFBF756109C767D92626967D19&\"");
	private static final String LATEST_LISTINGS_STR =
			"https://api.trademe.co.nz/v1/Listings/Latest.json";
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
			//Deals with the GSON file and allows us 
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
	public void writeRequest(){
		
	try{
		PrintWriter out = new PrintWriter("TEST_DATA.txt");
		out.print(requestListings(LATEST_LISTINGS_STR));
		out.close();
	}catch(IOException e){}
	}
	
	/*public static void main(String [ ] args){
		TMLRequest da = new TMLRequest();
	     da.writeRequest();
	}*/
	
}
