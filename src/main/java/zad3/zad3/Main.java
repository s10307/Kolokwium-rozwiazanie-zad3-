package zad3.zad3;

import java.util.ArrayList;
import java.util.List;

import zad3.zad3.Pracownik;
import zad3.zad3.KomunikacjaDB;

public class Main {

	public static void main(String[] args) {
		Pracownik Pracownik1 = new Pracownik("Jasiu", "Fafalski", "Pizza #1");
		Pracownik Pracownik2 = new Pracownik("Grzegorz", "Lato", "Pizzeria: Endless summer");

		List<Pracownik> ListaPracownikow = new ArrayList<Pracownik>();
		ListaPracownikow.add(Pracownik1);
		ListaPracownikow.add(Pracownik2);
		
		KomunikacjaDB KomunikacjaDB= new KomunikacjaDB();

		KomunikacjaDB.addPracownik(Pracownik1);
		KomunikacjaDB.addPracownik(Pracownik2);
		System.out.println("Wsyzscy pracownicy:");
		for (Pracownik pracownik : KomunikacjaDB.getAllPracownik()) {
			System.out.println("Imie= " + pracownik.getNazwisko());
			System.out.println("Nazwisko= " + pracownik.getNazwisko());
		}
	}
	
}
