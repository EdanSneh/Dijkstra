import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
//http://i.stack.imgur.com/90Qwu.png
public class Main {
	static Map map = new Map(1);
	static HashMap<String, HashMap<String, Integer>> nodemap = Map.getmap();
	static ArrayList<Boolean> k = new ArrayList<Boolean>();
	static ArrayList<String> pv = new ArrayList<String>();
	static ArrayList<Double> dv = new ArrayList<Double>();
	static ArrayList<String> nodes = new ArrayList<String>();
	static HashMap<String, ArrayList<Object>> table = new HashMap<String, ArrayList<Object>>();
	public static void main(String[] args) {
		double distance;
		String startnode = "A";
		initialize(nodemap);
		//start();
		dijkstra(nodemap, startnode);
		distance = dv.get(5);
		System.out.println(nodes);
		System.out.println(pv);
		System.out.println(dv);
		System.out.println(distance);
	}

	
	private static double endpoint(HashMap<String, HashMap<String, Integer>> map, String start, String end) {
		String previousnode = end;
		double distance = 0;
		while(previousnode != start){
			System.out.println(dv.get(nodes.indexOf(previousnode)));
			distance += dv.get(nodes.indexOf(previousnode));
			previousnode = pv.get(nodes.indexOf(previousnode));
		}
		return distance;
	}


	private static void dijkstra(HashMap<String, HashMap<String, Integer>> map, String startnode) {
		//TODO map the start node
		if(!(k.contains(true))){
			dv.set(nodes.indexOf(startnode), 0.0);
		}
		
		k.set(nodes.indexOf(startnode), true);		
		Set<String> keys = map.get(startnode).keySet();
		for(String key: keys){
			int num;	
			num = nodes.indexOf(key);
			
			//checks to see if distance of node is already greater in table
			if(k.get(num) == false && dv.get(num) > (double)(map.get(startnode).get(key))){
				
				dv.set(num, (double)(map.get(startnode).get(key))+dv.get(nodes.indexOf(startnode)));
				pv.set(num, startnode);
			}
		}
		startnode = nodes.get(smallest(dv));
		
		if(k.contains(false)){
			dijkstra(map, startnode);
		}
	}


	private static int smallest(ArrayList<Double> list) {
		if(list.size()<1){
			System.err.println("ArrayList<Double> not long enough");
			System.exit(1);
		}
		int index = 0;
		double smallestval = list.get(0);
		
		for(int j = 0; j<list.size(); j++){
			if(k.get(j) == false){
				index = j;
				smallestval = list.get(j);
			}
		}
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)<smallestval&& k.get(i) == false){
					smallestval = list.get(i);
					index = i;
				
			}
		}
		return index;
	}


	private static void initialize(HashMap<String, HashMap<String, Integer>> nodemap){
		Set<String> keys = nodemap.keySet();
		for(String key: keys){
			k.add(false);
			pv.add(null);
			dv.add(Double.POSITIVE_INFINITY);
			nodes.add(key);
		}
	}
}
