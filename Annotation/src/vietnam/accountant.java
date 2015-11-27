package vietnam;

public class accountant extends staff {
	@Override
	public void setName(String name) {
		super.setName(name);
		System.out.println("This is a override function");
	}
	
	@Override
	public void writeName() {
		super.writeName();
	}
}
