package zad3.zad3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zad3.zad3.Pracownik;
import zad3.zad3.KomunikacjaDB;

public class KomunikacjaDBTest {

	KomunikacjaDB KomunikacjaDB = new KomunikacjaDB();
	@Before
	public void setUp() throws Exception {
		KomunikacjaDB.addPracownik(new Pracownik("Imie", "Nazwisko", "NazwaPizzerii"));
	}

	@After
	public void tearDown() throws Exception {
		KomunikacjaDB.deleteAllPracownik();
	}

	@Test
	public void testAddPracownik() {
		KomunikacjaDB.addPracownik(new Pracownik("Imie2","Nazwisko2","NazwaPizzerii2"));
		assertEquals(2, KomunikacjaDB.getAllPracownik().size());
	}

	@Test
	public void testGetAllPracownik() {
		assertEquals(1, KomunikacjaDB.getAllPracownik().size());
	}

	@Test
	public void testDeleteAllPracownik() {
		KomunikacjaDB.deleteAllPracownik();
		assertTrue(KomunikacjaDB.getAllPracownik().isEmpty());
	}

	@Test
	public void testFindPracownikByImie() {
		KomunikacjaDB.addPracownik(new Pracownik("Imie","Nazwisko2", "NazwaPizzerii"));
		assertEquals(2, KomunikacjaDB.findPracownikByImie("Imie").size());
	}

	@Test
	public void testFindPracownikByNazwisko() {
		KomunikacjaDB.addPracownik(new Pracownik("Imie2","Nazwisko", "NazwaPizzerii"));
		KomunikacjaDB.addPracownik(new Pracownik("Imie2","Nazwisko2", "NazwaPizzerii2"));
		assertEquals(2, KomunikacjaDB.findPracownikByNazwisko("Nazwisko").size());
	}

		
	@Test
	public void testDeletePracownik() {
		KomunikacjaDB.addPracownik(new Pracownik("Imie2","Nazwisko", "NazwaPizzerii"));
		KomunikacjaDB.addPracownik(new Pracownik("Imie2","Nazwisko2", "NazwaPizzerii2"));
		KomunikacjaDB.deletePracownik(KomunikacjaDB.findPracownikByImie("Imie"));
		assertEquals(2, KomunikacjaDB.getAllPracownik().size());
	}
	

}
