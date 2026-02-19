import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

class Topsort {
	public static void main(String[] args) {
		int[][] reqs = new int[][]{{2,1}, {3,1}, {4, 3}, {4,1}};
		List<Integer> order = Topsort.topsort(reqs.length, reqs);
		order.forEach(System.out::println);
	}

	/*
	 * topsort [[b, a], ...]
	 * where a,b is the src, dest respectively
	 * @param: int elements
	 * @param: int[][] graph
	 */
	public static List<Integer> topsort(int elements, int[][] preqs) {
		Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
		Map<Integer, Integer> inDegrees = new HashMap<>();

		for (int i=0; i<preqs.length; i++) {
			int src = preqs[i][1], dest = preqs[i][0];
			// model the Graph: [[a,[b,..]], ...]
			adjacentMap.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
			// in-degree of each node
			inDegrees.put(dest, inDegrees.getOrDefault(dest, 0) + 1);
			inDegrees.putIfAbsent(src, 0);
		}
		// add all nodes whose in-degree is 0 to a queue
		Queue<Integer> queue = new LinkedList<Integer>();
		for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
			if (entry.getValue() == 0)
				queue.add(entry.getKey());
		}
		return traverse(queue, adjacentMap, inDegrees);	
	}

	/*
	 * traverse in FIFO for neighbors who have no indegree
	 * @param: Queue<Integer>
	 * @param: Map<Integer, List<Integer>> i.e dependencies : [dependants]
	 * @param: Map<Integer, Integer>indegrees
	 */
	private static List<Integer> traverse(
			Queue<Integer> queue,
			Map<Integer, List<Integer>> adjacentMap,
			Map<Integer, Integer> inDegrees
			) {
		List<Integer> topOrder = new ArrayList<>();
		while (!queue.isEmpty()) {
		    int node = queue.poll();
		    topOrder.add(node);
		    if (adjacentMap.containsKey(node)) {
				    for (int neighbour : adjacentMap.get(node)) {
				        inDegrees.put(neighbour, inDegrees.get(neighbour) - 1);
					      if (inDegrees.get(neighbour) == 0) {
						        queue.add(neighbour);
					      }
			      }
			  }
		}
		if (topOrder.size() != inDegrees.size())
			throw new IllegalStateException("Graph has a cycle!");
		return topOrder;
	}
}
