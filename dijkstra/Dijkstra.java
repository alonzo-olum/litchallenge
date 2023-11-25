import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import java.util.stream.Collectors;

public class Dijkstra {

	public static int calculateShortestPathFromSource(Graph graph, Node source) {
		source.setDistance(0);

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes  = new HashSet<>();
		unsettledNodes.add(source);

		while(unsettledNodes.size() != 0) {
			try {
				Node current = getLowestDistanceNode(unsettledNodes);
			} catch (IllegalStateException ex) {
				// just return graph
				// we need to log this as well
				break;
			}
			unsettledNodes.remove(current);

			for(Entry <Node, Integer> adjacencyPair : current.getAdjacentNodes().entrySet()) {
				Node adjacent = adjacencyPair.getKey();
				Integer distance = adjacencyPair.getValue();
				if (!settledNodes.contains(adjacent)) {
					calculateMinDistance(adjacent, distance, current);
					unsettledNodes.add(adjacent);
				}
			}
			settledNodes.add(current);
		}
		return graph;
	}

	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) throws IllegalStateException {
		return unsettledNodes.stream()
			.min(Comparator.comparingInt(Node::getDistance))
			.orElseThrow(new IllegalStateException("source node is required to be at minimum"));;
	}

	private static void calculateMinDistance(Node evaluationNode, int edgeWeight, Node sourceNode) {
		if (sourceNode.getDistance() + edgeWeight < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceNode.getDistance() + edgeWeight);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
	}
}
