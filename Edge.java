
public class Edge {

	// Private fields
	private Node start; 		// The starting node of the directed graph
	private Node end; 			// The node that the start Node transitions to 
	
	// Initialize the Edge object via the constructor
	public Edge(Node start, Node end) {
		this.start = start;
		this.end = end;
	}
	
	// Methods
	public int getStartingNodeId() {		// Return identifier of starting Node
		return start.getId();			
	}
	
	public int getEndingNodeId() {			// Return identifier of ending Node
		return end.getId();
	}
	
	@Override 
	public String toString() {				// Used for debugging
		return String.format("Edge(%d -> %d) ", start.getId(), end.getId());
	}
}
