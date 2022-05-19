package csi;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJSON {
	public static List<PointData> parseData(String filename) {
		
		List<PointData> points = new ArrayList<PointData>();
    	
    	JSONParser parser = new JSONParser();
    	
    	try (Reader reader = new FileReader(filename)){
	        JSONObject obj = (JSONObject) parser.parse(reader);
	
	        JSONArray arr = (JSONArray) obj.get("results");
	        
	        Iterator<JSONObject> iterator = arr.iterator();
	        while (iterator.hasNext()) {
	            JSONObject item = iterator.next();
	            JSONObject location = (JSONObject) item.get("location");
	           
	            double elevation = new Double(item.get("elevation").toString());
	            double latitude = (double) location.get("lat");
	            double longitude = (double) location.get("lng");
	            
	            points.add(new PointData(elevation, new Coords(latitude, longitude)));
	        }
	        
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
		return points;
	}
}
