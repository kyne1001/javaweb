package vietnam;

public class tutorial {

	/**
	 * Deprecated, replace with {@link #newFunction()}
	 */
	@Deprecated
	public void oldFunction() {
		System.out.println("This is an old function");
	}
	
	public void newFunction() {
		System.out.println("This is a new function");
	}
	
	@MyAnno(name = "Pop")
	public static void main(String[] args) {
		tutorial Tu = new tutorial();
		Tu.oldFunction();
		Tu.newFunction();
		
		accountant acc = new accountant();
		acc.setName("Pop");
		acc.writeName();
	}

}
