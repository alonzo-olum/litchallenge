import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * session is valid if:
 * START = first event
 * END = last event
 * ERROR = must precede atleast one ACTION
 * ACTION = before END
 */
class DebugLog {
	private static final int START = 0;
	private static final int END = 1;
	private static final int ACTION = 2;
	private static final int ERROR = 3;

	public static boolean isValid(List<Integer> events) {
		Queue<Integer> frontier = new LinkedList<>();
		Set<Integer> explored = new HashSet<>();
		// until START is encountered as first event
		int index = 0;
		int firstEvent = events.get(index);
		if (firstEvent != START)
			return false;
		// START is first, so we check for END
		if (events.get(events.size() - 1) != END) {
			return false;
		}
		boolean err = false;
		frontier.offer(events.get(++index));
		while (!frontier.isEmpty() && index < events.size() - 1) {
			int e = frontier.poll();
			if (explored.contains(e))
				continue;
			explored.add(e);
			// if ACTION
			if (e == ACTION) {
				// ERROR not encountered
				if (!err) {
					return false;
				}
				// ERROR encountered
				err = false;
			}
			// ERROR encountered
			if (e == ERROR) {
				err = true;
			}
			// add next event to queue
			frontier.offer(events.get(++index));
		}
		// no unresolved errrors
		return !err;
	}

	public static void main(String[] args) {
		List<Integer> events = new ArrayList<>();
		events.add(0, 0);
		events.add(1, 3);
		events.add(2, 2);
		events.add(3, 1);
		System.out.println(isValid(events));
	}
}
