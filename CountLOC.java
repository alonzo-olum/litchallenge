import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;

import java.nio.file.Files;
import java.nio.file.Paths;

class CountLOC {

	private static final CharSequence NEWLINE = "\n";
	private static final CharSequence DOUBLE_SLASH = "//";
	private static final CharSequence SINGLE_SLASH_STAR = "/*";
	private static final CharSequence STAR_SLASH = "*/";

	public static int count(String text) throws IOException {
		try (BufferedReader in = new BufferedReader(new StringReader(text))) {
		    long count = in.lines()
					.filter(CountLOC::isNotComment)
					.count();
		    return (int) count;
		}
	}

	private static boolean isNotComment(String line) {
		return !line.isEmpty() || !line.contains(NEWLINE) || !line.contains(DOUBLE_SLASH)
			|| !line.contains(SINGLE_SLASH_STAR) || !line.contains(STAR_SLASH);
	}

	public static void main(String[] args) {
		try {
			/*
			 * The reason we are chasing our tail here, is because
			 * the interview question (for some reason) insisted on
			 * reading the entire source file into byte String.
			 * We could have easily used Files.lines(path)
			 * Ofcourse we can construct path from static factory Path.get(filename)
			 */
		    byte[] readBytes = Files.readAllBytes(Paths.get(args[0]));
		    String text = new String(readBytes); 
	      System.out.println(CountLOC.count(text));
		} catch (IOException ex) {
			//
		}
	}
}
