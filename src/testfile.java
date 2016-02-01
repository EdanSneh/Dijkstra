import java.util.ArrayList;
import java.util.HashMap;


public class testfile {
	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> nodemap = Map.getmap();
		String startnode = "A";
		Dijkstra myD = new Dijkstra(nodemap, startnode);
		//TODO return the path from start to end
		ArrayList<String> path = myD.next("G","H",myD);
	}
}
