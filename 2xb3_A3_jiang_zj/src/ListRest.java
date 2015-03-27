import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.*;

public class ListRest{
	private BST<Double, Rest> rests = new BST<Double, Rest>();
	private double lat;
	private double lon;
	
	private static class Rest {
		private double lat;
		private double lon;
		private String name;
		private String addr;
		
		public Rest(double lat, double lon, String name, String addr) {
			this.lat = lat;
			this.lon = lon;
			this.name = name;
			this.addr = addr;
		}
		
//		public double getDist(double[] coord) {
//			return this.getDist(coord[0], coord[1]);
//		}
		
		// calculate the distance of given point to this restaurant
		public double getDist(double lat2, double lon2) {
			double R = 6371000; // metres
			double ¦Õ1 = Math.toRadians(this.lat);
			double ¦Õ2 = Math.toRadians(lat2);
			double ¦¤¦Õ = Math.toRadians(lat2 - this.lat);
			double ¦¤¦Ë = Math.toRadians(lon2 - this.lon);

			double a = Math.sin(¦¤¦Õ/2) * Math.sin(¦¤¦Õ/2) +
			        Math.cos(¦Õ1) * Math.cos(¦Õ2) *
			        Math.sin(¦¤¦Ë/2) * Math.sin(¦¤¦Ë/2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

			double d = R * c;
			return d/1000;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getAddr() {
			return this.addr;
		}
	}
	
	public ListRest(double lat, double lon, String path) throws IOException {
		this.lat = lat;
		this.lon = lon;
		Reader in = new FileReader(path);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		Rest[] list = null;
//		int i = 0;
		// 
		for (CSVRecord record: records) {
			// value is the Restaurant 
			Rest value = new Rest(
					Double.parseDouble(record.get(1)),
					Double.parseDouble(record.get(0)),
					record.get(2),
					record.get(3)
			);
			// key is the distance from given point to Restaurant
			double key = value.getDist(lat, lon);
			rests.put(key, value);
//			i++;
//			if(key <= 125.0) {
//				System.out.println("from");
//				System.out.println(this.lat + "," + this.lon);
//				System.out.println("to");
//				System.out.println(record.get(1) + "," + record.get(0));
//				System.out.println("takes");
//				System.out.println(key);
//				System.out.println("or");
//				System.out.println(value.getDist(lat, lon));
//				System.out.println(record.get(2) + "," + record.get(3));
//			}
		}
	}

	
	public static void main(String args[]) throws IOException {
		double[] coord = new double[]{43.1656, -77.6114};
		double dist = 11.1;
		ListRest BK = new ListRest(43.1656, -77.6114 , "data/burgerking.csv");
		ListRest Mac = new ListRest(43.1656, -77.6114 , "data/mcdonalds.csv");
		ListRest Wendys = new ListRest(43.1656, -77.6114 , "data/wendys.csv");
		
		Rest testRest = new Rest(43.130919, -77.668563, "", "");
//		System.out.println(testRest.getDist(43.1656, -77.6114));
		
		Iterable<Rest> list = BK.rests.keys(0.0, 50.0);
		System.out.println("Expected");
		for(Rest ele: list) {
			System.out.println(ele.getName() +"," + ele.getAddr());
		}
		list = Mac.rests.keys(0.0, 50.0);
		System.out.println("Expected");
		for(Rest ele: list) {
			System.out.println(ele.getName() +"," + ele.getAddr());
		}

		list = Wendys.rests.keys(0.0, 50.0);
		System.out.println("Expected");
		for(Rest ele: list) {
			System.out.println(ele.getName() +"," + ele.getAddr());
		}


	}
}
