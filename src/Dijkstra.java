import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
//http://i.stack.imgur.com/90Qwu.png
public class Dijkstra implements Shorty{
	
	//static HashMap<String, HashMap<String, Integer>> nodemap;
	ArrayList<Boolean> k = new ArrayList<Boolean>();
	ArrayList<String> pv = new ArrayList<String>();
	ArrayList<Integer> dv = new ArrayList<Integer>();
	ArrayList<String> nodes = new ArrayList<String>();
	HashMap<String, ArrayList<Object>> table = new HashMap<String, ArrayList<Object>>();
	String sstartnode;
	HashMap<String, ArrayList<String>> paths = new HashMap<String, ArrayList<String>>();
	
	/**
	 * Constructor that takes in the start node and map and encapsulates the rest of the methods.
	 * @param map
	 * @param startnode
	 */
	public Dijkstra(HashMap<String, HashMap<String, Integer>> map, String startnode){
		initialize(map);
		sstartnode = startnode;
		map.path();
		dijkstra(map, startnode);
		pathconvertor(map);
		
	}
	/**
	 * Creates all the different paths to different nodes
	 * @param nodemap
	 */
	private void pathconvertor(HashMap<String, HashMap<String, Integer>> nodemap) {
		Set<String> keys = nodemap.keySet();
		for(String key: keys){
			String previousnode = key;
			ArrayList<String> path = new ArrayList<String>();
			while(previousnode != sstartnode){
				path.add(0, pv.get(nodes.indexOf(previousnode)));
				previousnode = pv.get(nodes.indexOf(previousnode));
			}
			paths.put(key, path);
		}
	}
	
	/**
	 * Creates a blank table for the dijkstra
	 * @param nodemap
	 */
	private void initialize(HashMap<String, HashMap<String, Integer>> nodemap){
		Set<String> keys = nodemap.keySet();
		for(String key: keys){
			k.add(false);
			pv.add(null);
			dv.add(Integer.MAX_VALUE);
			nodes.add(key);
		}
	}

	private void dijkstra(HashMap<String, HashMap<String, Integer>> map, String startnode) {
		if(!(k.contains(true))){
			dv.set(nodes.indexOf(startnode), 0);
		}
		
		k.set(nodes.indexOf(startnode), true);		
		Set<String> keys = map.get(startnode).keySet();
		for(String key: keys){
			int num;	
			num = nodes.indexOf(key);
			
			//checks to see if distance of node is already greater in table
			if(k.get(num) == false && dv.get(num) > map.get(startnode).get(key)){
				
				dv.set(num, map.get(startnode).get(key)+dv.get(nodes.indexOf(startnode)));
				pv.set(num, startnode);
			}
		}
		startnode = nodes.get(smallest(dv));
		
		if(k.contains(false)){
			dijkstra(map, startnode);
		}
	}


	private int smallest(ArrayList<Integer> list) {
		if(list.size()<1){
			System.err.println("ArrayList<Double> not long enough");
			System.exit(1);
		}
		int index = 0;
		int smallestval = list.get(0);
		
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


	
	
	public int getDistance(String endnode){
		return dv.get(nodes.indexOf(endnode));
	}
	
	public ArrayList<String> next(String endnode){
		return paths.get(endnode);
	}
	/**
	 * returns all the paths to strings in the Dijkstra
	 */
	public HashMap<String, String> path() {
		Set<String> keys = this.keySet();
		for(String key: keys){
			
		}
		return null;
	}
}
