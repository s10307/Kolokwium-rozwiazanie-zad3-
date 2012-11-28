package zad3.zad3;

abstract class Pizza {
	String name = "Pizza";
		
	public void preparing() {
		System.out.println("Przygotowanie pizzy.");
	}

	public void baking() {
		System.out.println("Pieczenie pizzy.");
	}

	public void cutting() {
		System.out.println("Krojenie pizzy.");
	}

	public void packaging() {
		System.out.println("Pakowanie pizzy.");
	}
}
