import java.util.ArrayList;
import java.util.HashMap;


public class testfile {
	
	/**
	 * this file is only here to test out dijkstra
	 * @param args
	 */
	public static void main(String[] args) {
		Map map = new Map(1);
		HashMap<String, HashMap<String, Integer>> nodemap = map.getmap();
		
		String startnode = "A";
		String endnode = "E";
		int Distance;
		Dijkstra myD = new Dijkstra(nodemap, startnode);
		
		Distance = myD.getDistance(endnode);
		System.out.println(Distance);
		ArrayList<String> path = myD.next(endnode);
		System.out.println(path);
	}
}
