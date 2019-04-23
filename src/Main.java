
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model atmModel = new Model();
		View atmView = new View(atmModel);
		Controller atmController = new Controller(atmView, atmModel);

	}

}
