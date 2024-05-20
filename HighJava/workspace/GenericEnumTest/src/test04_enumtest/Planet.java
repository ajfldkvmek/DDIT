package test04_enumtest;

public enum Planet {
	수성(2439), 
	금성(6052), 
	지구(6371), 
	화성(3390), 
	목성(69911), 
	토성(58232), 
	천왕성(25362), 
	해왕성(24622);
	
	private int data;
	Planet(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
}
