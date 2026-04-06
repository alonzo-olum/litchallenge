import java.util.List;
import java.util.ArrayList;

class ZigZag {
	public static String zigzag(
			String s,
			int numRows
			) {
		if (numRows == 1) return s;

		List<StringBuilder> rows =  new ArrayList<>();
		for (int i = 0; i 
				< Math.min(numRows, s.length()); i++) {
			rows.add(new StringBuilder());
				}

		int curRow = 0;
		boolean down = false;
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				down = !down;
			}
			curRow = incrementOrDecrementRow(curRow, down);
		}

		StringBuilder res = new StringBuilder();
		for (StringBuilder row : rows) res.append(row);
		return res.toString();
			}

	private boolean incrementOrDecrementRow(int currentRow, boolean down) {
		currentRow + = down ? 1 : -1;
		return currentRow;
	}
}
