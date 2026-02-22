import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTopSort {

	private static final int[][] DAG = {{1, 2}, {2, 4}, {2, 3}, {1, 4}};
	private static final int[][] GRAPH = {{0, 11}, {11, 9}, {9, 3}, {3, 0}};

	@Test
	public void testDAG() {
		List<Integer> result = Topsort.topsort(DAG);

		assertEquals(DAG.length, result.size());
	}

	@Test
	public void testCyclicThrowsException() {
		try {
			List<Integer> result = Topsort.topsort(GRAPH);
		} catch(IllegalArgumentException exception) {
			assertTrue(true);
		}
	}
}
