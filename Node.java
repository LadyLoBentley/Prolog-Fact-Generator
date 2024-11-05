
public class Node {
	
	// Private Fields
	private final int id; 		// Node identifier: 1, 2, 3, 4, 5, ..., 1000
	
	// Initialize the Node object via the constructor
	public Node(int identifier) {
		this.id = identifier;
	}
	
	// Methods
	public int getId() {		// Returns the identifier of the Node object 
		return id; 
	}
}
