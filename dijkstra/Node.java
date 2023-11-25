import java.util.HashMap;
import java.util.LinkedList;

public class Node {
	private String name;
	private LinkedList<Node> shortestPath = new LinkedList<>();
	private Integer distance = Integer.MAX_VALUE;
	private Map<Node, Integer> adjacentNodes = new HashMap<>();

	public Node(String name) {
		this.name = name;
	}

	public void addDestination(Node node, int distance) {
		this.adjacentNodes.put(node, distance);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return this.adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Node> getShortestPath() {
		return this.shortestPath;
	}

	public void setShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}
}
