package org.csi.GoogleMapsAPI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class App {
    public static void main( String[] args ) {
    try {
    	
    	Data Olsztyn = new Data(54.3612063, 18.5499457);
    	Data Gdansk = new Data(53.7760917, 20.3956595);
    	
    	URL url = new URL("https://maps.googleapis.com/maps/api/elevation/json?path="+ Olsztyn.to_s()
    						+"|" + Gdansk.to_s() +"&samples=50&key=API_KEY");

    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
    	String strTemp = "";
    	while (null != (strTemp = br.readLine())) {
    		toFile("GdanskOlsztyn.json", strTemp);
    	}
   		} catch (Exception ex) {
   			ex.printStackTrace();
   		}
   	}
    
	private static void toFile(String fileName, String content) {
		try(FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
