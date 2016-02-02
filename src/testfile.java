import java.util.ArrayList;
import java.util.HashMap;


public class testfile {
	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> nodemap = Map.getmap();
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
