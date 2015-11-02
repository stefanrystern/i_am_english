package textUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	
	public String readTextFile(String fileFullPath){
		String everything = "";
		try(BufferedReader br = new BufferedReader(new FileReader(fileFullPath))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(" ");
		        line = br.readLine();
		    }
		    everything = everything + sb.toString();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return everything;
	}

}
