package zad3.zad3;


abstract class Pizzeria {

	String nazwaPizzerii;
	Pizza pizza;
	
	
}

class ItalianPizzeria extends Pizzeria {

	public Pizza createPizza() {
	
			return pizza;		
		
	}
}

class PolishPizzeria extends Pizzeria {

	public Pizza createPizza() {
	
			return pizza;		
		
	}
}

