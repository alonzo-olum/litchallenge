
public class Entity{

	protected String entity_name;
	protected String entity_last_name, entity_first_name;

	public Entity( String entity_first_name, String entity_last_name){

		this.entity_first_name=entity_first_name;
		this.entity_last_name=entity_last_name;
	}

	public String getFullName(){
		if(entity_name!=null)
			return entity_name;
		return entity_first_name +" "+ entity_last_name;

	}
	public static void main(String[] args){
		Entity e = new Entity("Alonzo","Olum");
		System.out.println("Entity Full name is:"+e.getFullName());
	}
}
