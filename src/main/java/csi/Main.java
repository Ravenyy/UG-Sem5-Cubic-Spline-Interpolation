package csi;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    	List<PointData> list = GetDataFromJSON.parseData("OlsztynGdansk.json");

    	System.out.println("Ilość punktów: " + list.size() + "\n");
    	for(PointData point : list) {
    		System.out.println(point.getElevation() + ", " + point.getCoords().getX() + ", " + point.getCoords().getY());
    	}
    }
}
