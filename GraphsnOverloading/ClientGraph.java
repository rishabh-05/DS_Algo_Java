package GraphsnOverloading;

import java.util.HashSet;

public class ClientGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("B", "C", 3);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("F", "G", 4);
		graph.addEdge("E", "G", 7);

		System.out.println(graph);
		
		//graph.removeVertex("C");
		
		//System.out.println(graph);
		//graph.removeEdge("F", "E");
		
//		System.out.println(graph.hasPath("A", "G", new HashSet<String>()));
//		graph.printAllPaths("A","G");
	//	System.out.println(graph.BFS("A", "G"));

//		System.out.println(graph.getCC());
//		System.out.println(graph.isBipartite());
		System.out.println(graph.prims());
		
		
	
	}

}
