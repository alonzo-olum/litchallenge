import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.stream.IntStream;

class Topsort {
	public static int[] topsort(int elements, int[][] preqs) {
		/* model the Graph: [[a,b]]
		 * where a,b is the dest,src respectively
		 */
		Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
		/*
		 * in-degree of each node
		 */
		int[] inDegree = new int[elements];
		/*
		 * output correct sequence
		 */
		int[] topOrder = new int[elements];
		for (int i=0; i<preqs.length; i++) {
			int src = preqs[i][1];
			int dest = preqs[i][0];

			List<Integer> list = adjacentMap.getOrDefault(src,
					new ArrayList<Integer>());
			list.add(dest);
			adjacentMap.put(src, list);
			inDegree[dest] += 1;
		}
		/*
		 * add all nodes whose in-degree is 0
		 * use a queue for that
		 */
		Queue<Integer> queue = new LinkedList<Integer>();
		IntStream.range(0, elements)
			.filter(i -> inDegree[i] == 0)
			.forEach(i -> queue.add(i)); // although this is concise, this side-effect equals bad code smell

		int i = 0;
		
		while (!queue.isEmpty()) {
		    int node = queue.remove();
		    topOrder[i++] = node;
		    if (adjacentMap.containsKey(node)) {
				    for (Integer neighbour : adjacentMap.get(node)) {
				        inDegree[neighbour]--;
					      if (inDegree[neighbour] == 0) {
						        queue.add(neighbour);
					      }
			      }
			  }
		}

		if (i == elements)
			return topOrder;

		return new int[0];
	}
}
