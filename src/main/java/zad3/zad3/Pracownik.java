package zad3.zad3;


import java.util.ArrayList;
import java.util.List;


public class Pracownik {

	String imie;
	String nazwisko;
	String nazwaPizzerii;
	List<Pracownik> ListaPracownikow;
	
	public Pracownik(String imie, String nazwisko, String nazwaPizzerii) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.ListaPracownikow = new ArrayList<Pracownik>();
	}
	
	public void dodajPracownika(Pracownik k) {
		ListaPracownikow.add(new Pracownik(imie, nazwisko, nazwaPizzerii));
	}

	public void UsunPracownika(Pracownik k) {
		ListaPracownikow.remove(new Pracownik(imie, nazwisko, nazwaPizzerii));
	}
	
	public List<Pracownik> getListaPracownikow() {
		return ListaPracownikow;
	}

	public String getImie() {
		return imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}

	public String getNazwaPizzerii() {
		return nazwaPizzerii;
	}
	
}
