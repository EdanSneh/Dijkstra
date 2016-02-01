import java.util.HashMap;

public class Dijkstra {
	static HashMap<String, HashMap<String, Integer>> nodemap = new HashMap<String, HashMap<String, Integer>>();
	public Dijkstra(int i){
		if(i == 1){
			HashMap<String,Integer> nodeA = new HashMap<String, Integer>();
			HashMap<String,Integer> nodeB = new HashMap<String, Integer>();
			HashMap<String,Integer> nodeC = new HashMap<String, Integer>();
			HashMap<String,Integer> nodeD = new HashMap<String, Integer>();
			HashMap<String,Integer> nodeE = new HashMap<String, Integer>();
			HashMap<String,Integer> nodeF = new HashMap<String, Integer>();
			
			nodeA.put("B", 3);
			nodeA.put("C", 5);
			nodeA.put("D", 9);
			
			nodeB.put("A", 3);
			nodeB.put("C", 3);
			nodeB.put("D", 4);
			nodeB.put("E", 7);
			
			nodeC.put("A", 5);
			nodeC.put("B", 3);
			nodeC.put("D", 2);
			nodeC.put("E", 6);
			nodeC.put("F", 8);
			
			nodeD.put("A", 9);
			nodeD.put("B", 4);
			nodeD.put("C", 2);
			nodeD.put("E", 2);
			nodeD.put("F", 2);
			
			nodeE.put("B", 7);
			nodeE.put("C", 6);
			nodeE.put("D", 2);
			nodeE.put("F", 5);
			
			nodeF.put("C", 8);
			nodeF.put("D", 2);
			nodeF.put("E", 5);
			
			nodemap.put("A", nodeA);
			nodemap.put("B", nodeB);
			nodemap.put("C", nodeC);
			nodemap.put("D", nodeD);
			nodemap.put("E", nodeE);
			nodemap.put("F", nodeF);
			
		}
		//System.out.println(nodemap.get("A").get("B"));
	}
	public static HashMap<String, HashMap<String, Integer>> getmap(){
		return nodemap;
	}
}

class table{
	public table(){
		
	
	}	
}
