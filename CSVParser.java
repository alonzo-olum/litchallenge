import java.util.List;

public class CSVParser{

	public static void main( String[] args){

		CSV parser = new CSV();
		List list = parser.parse(
			"\\"REC\\"",92.3,\\"21/10/1990\\","\\3:45PM\\",+4.0635");
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
			
	
	}


}
