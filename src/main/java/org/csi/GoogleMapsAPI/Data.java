package org.csi.GoogleMapsAPI;

public class Data {
	double lat;
	double lng;
	
	public Data(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	
	String to_s() {
		String str = this.lat + "," + this.lng;
		return str;
	}
	
}
