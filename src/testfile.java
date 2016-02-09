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
		
		String startnode = "E";
		String endnode = "A";
		int Distance;
		Dijkstra myD = new Dijkstra(nodemap, startnode);
		
		Distance = myD.getDistance(endnode);
//		System.out.println(myD.nodes);
//		System.out.println(myD.pv);
//		System.out.println(myD.k);
//		System.out.println(myD.dv);
		
		System.out.println("Distance of "+endnode+": "+Distance);
		System.out.println("Path Map: "+myD.path);
		ArrayList<String> pathendnode = myD.next(endnode, nodemap);
		System.out.println("next " + endnode + ": "+pathendnode);
	}
}
