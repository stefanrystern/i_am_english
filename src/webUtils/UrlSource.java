package webUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlSource {
	
	public String getUrlSource(String url){
		String result = "";
		
		try{
			URL urlToFetchSource = new URL(url);
	
			BufferedReader in = new BufferedReader(new InputStreamReader(urlToFetchSource.openStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
			  response.append(inputLine + "\n");
			}
			
			result = response.toString();
			
			in.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return result;
	}

}
