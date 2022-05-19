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

public class CSI {
	
	public double getDistance(double x1, double x2, double y1, double y2) {
		double subx = x1 - x2;
		double suby = y1 - y2;
		double result = Math.sqrt(Math.pow(subx, 2) + Math.pow(suby, 2));
		return result;
	}

	public Coords getCoordsFromDistance(List<PointData> list, double distance) {
		double x1 = list.get(0).getCoords().getX();
		double y1 = list.get(0).getCoords().getY();
		double x2 = list.get(list.size() - 1).getCoords().getX();
		double y2 = list.get(list.size() - 1).getCoords().getY();
		double s = distance / getDistance(x1, x2, y1, y2);
		double x = (x2 - x1) * s + x1;
		double y = (y2 - y1) * s + y1;
		Coords coords = new Coords(x, y);
		return coords;
	}
}