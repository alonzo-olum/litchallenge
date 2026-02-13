import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;

import java.nio.file.Files;
import java.nio.file.Paths;

class CountLOC {

	private static final String NEWLINE = "\n";
	private static final String DOUBLE_SLASH = "//";
	private static final String SINGLE_SLASH_STAR = "/*";
	private static final String STAR_SLASH = "*/";

	public static int count(String text) throws IOException {
		int count = 0;
		try (BufferedReader in = new BufferedReader(new StringReader(text))) {
			boolean inComment = false;

			String line;
			while ((line = in.readLine()) != null){
				line.trim();
				// Case where line is empty
				if (line.isEmpty())
					continue;
				// Case where we encounter ending */
				if (text.endsWith(STAR_SLASH)) {
					if (inComment)
						inComment = false;
					continue;
				}
				// Case where we encounter //
				if (text.startsWith(DOUBLE_SLASH)) {
					continue;
				}
				//Case where we encounter starting /*
				if (text.startsWith(SINGLE_SLASH_STAR)) {
					inComment = true;
					if (text.endsWith(STAR_SLASH))
							inComment = false;
					continue;
				}

				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
			byte[] readBytes = Files.readAllBytes(Paths.get(args[0]));
			String text = new String(readBytes); 
			System.out.println(CountLOC.count(text));
	}
}
