import GraphsnOverloading.Graph;

public class ClientGraphRevise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphRevision graph = new GraphRevision();
		graph.addVertex("A");
		graph.addVertex("H");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "H", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("H", "C", 3);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("F", "G", 4);
		graph.addEdge("E", "G", 7);

		//System.out.println(graph);
		
		graph.display();
		
		System.out.println(graph.numEdges() + " " + graph.numVertices());
		
//		graph.removeVertex("A");
//		graph.removeEdge("D", "E");
		System.out.println(graph.hasPath("A", "F"));
//		graph.display();
		graph.printPaths("A", "F");
		System.out.println(graph.DFS("A", "F"));
		System.out.println(graph.BFS("A", "F"));
		System.out.println("-----------------");
		graph.BFT();
		System.out.println("-----------------");
		graph.DFT();
	}

}
