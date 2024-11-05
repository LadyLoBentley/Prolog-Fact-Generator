import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	
	// Private fields
	private ArrayList<Node> nodes;		// ArrayList containing nodes of the directed graph
	private ArrayList<Edge> edges;		// ArrayList containing edges of the directed graph
	
	// Initialize the graph object via the constructor
	public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}
	
	// Methods
	public void addNode(Node newNode) {		// Manually add new node to the nodes list
		nodes.add(newNode);
	}
	
	public void addEdge(Edge newEdge) {		// Manually add new edge to the edges list
		edges.add(newEdge);
	}
	
	/*
	 * Method that searches for a specified node based on the identifier provided in
	 * the argument.
	 */
	public Node findNodeById(int id) {
		for (Node node : nodes) {
			if (node.getId() == id) {	// if current node equals specified identifier,
				return node;			// return the node.
			}
		}
		return null;					// Otherwise, return null.
	}
	
	/*
	 * Method that generates a fact file for prolog indicating nodes as well as the
	 * nodes edges. The output is transferred to a separate file to be analyzed
	 * by Prolog.
	 */
	
	public void generateFactFile(String fileName) {
		try (FileWriter output = new FileWriter(fileName)) {
			for(Node node : nodes) {	// visit each node in list,
				// output each node as a prolog fact in separate file.
				output.write(String.format("node(%d).\n", node.getId()));	
			}														
			
			for(Edge edge : edges) {	// Visit each edge in list,
				// output each edge as a prolog fact in separate file.
				output.write(String.format("edge(%d, %d).\n", 
						edge.getStartingNodeId(), edge.getEndingNodeId()));
				// System.out.println("Writing edge to file: " + edge); // Debug statement
			}
		}
		catch (IOException error) {		// If error occurs, prevents program from crashing.
			System.out.println("An error occurred while writing to the file: " 
								+ error.getMessage());
		}
	}
}
