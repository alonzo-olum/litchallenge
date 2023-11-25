class simpleIN{

	public static void main(String[] args){
			int b=0;
		try{
			b=System.in.read();
		}catch(Exception ex){
			System.out.println("Caught "+ ex);
		}
		System.out.println("Read Out: "+ (char)b);
	}

}
