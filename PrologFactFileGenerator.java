import java.util.ArrayList;
import java.util.Random;

public class PrologFactFileGenerator {

	public static void main(String[] args) {
		
		int[] graphSizes = {10, 50, 100, 500, 1000};	// define 5 different sizes of graphs
		Random random = new Random();	// Generate size of directed graphs using Random object
	
		for (int size : graphSizes) {	// Create a directed for each size 
			
			// Declare and initialize a new directed graph for current size 
			Graph directedGraph = new Graph(new ArrayList<>(), new ArrayList<>());
			
			/*
			 * Add the number of nodes equal to the size of the directed graph to the graph
			 * object. We initialize the id starting at character 'A', then add 1 to each 
			 * character to move to the next such that A -> B -> C and so on. To determine 
			 * the number of iterations, add size to the initial value of id: 'A' + size.
			 */
			
			for (char id = 1; id <= size; id++) {
				Node node = new Node(id);					// Create new node
				directedGraph.addNode(node); 				// Add new node to graph
			}
			
			/* 
			 * Create directed edges connecting the nodes in the graph by generating a 
			 * random number not exceeding the size of the graph and adding it to the current
			 * identifier. Then, we want to set a condition that prevents self loops. 
			 * In regard to the number of iterations, I doubled the size to ensure that there
			 * are sufficient connections in the directed graph.
			 */
			
			for(int i = 0; i < size * 2; i++) {	// iterate the number of Node objects in graph
				int startId = random.nextInt(size) + 1;
				int endId = random.nextInt(size) + 1;
				
				if (startId != endId) {		// If start id and end id are not the same,
					
					// Search for the corresponding nodes.
					Node start = directedGraph.findNodeById(startId);
					Node end = directedGraph.findNodeById(endId);
					
					if (start != null && end != null) {	// If both nodes exist,
						directedGraph.addEdge(new Edge(start, end)); // Add new edge to graph.
					}
				}		
			}
			
			// Generate a fact file for prolog for the directed graph
			String fileName = size + "_Nodes_Graph.pl";	
			directedGraph.generateFactFile(fileName);
			System.out.println("Prolog fact file " + fileName + " is generated.");
			
		}
	}
}
