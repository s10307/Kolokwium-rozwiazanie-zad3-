package zad3.zad3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Condition;


public class KomunikacjaDB {

	List<Integer> listID = new ArrayList<Integer>();

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addPracownikStmt;
	private PreparedStatement getPracownikStmt;
	private PreparedStatement deleteAllPracownikStmt;
	private PreparedStatement deletePracownikStmt;
	private PreparedStatement findPracownikByImieStmt;
	private PreparedStatement findPracownikByNazwiskoStmt;
	private PreparedStatement findPracownikByNazwaPizzeriiStmt;

	public KomunikacjaDB() {
		try {
			Properties props = new Properties();

			try {
				props.load(ClassLoader
						.getSystemResourceAsStream("zad3/zad3/jdbc.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(props.getProperty("url"));

			stmt = conn.createStatement();
			boolean PracownikTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);

			while (rs.next()) {
				if ("Pracownik".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					PracownikTableExists = true;
					break;
				}
			}

			if (!PracownikTableExists) {
				stmt.executeUpdate("CREATE TABLE pracownik(id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
						+ "imie varchar(40), nazwisko varchar(40), nazwaPizzerii varchar(40))");
			}

			addPracownikStmt = conn
					.prepareStatement("INSERT INTO pracownik (imie, nazwisko, nazwapizzerii) VALUES (?,?,?)");

			getPracownikStmt = conn.prepareStatement("SELECT * FROM pracownik");

			deleteAllPracownikStmt = conn
					.prepareStatement("DELETE FROM pracownik");

			findPracownikByImieStmt = conn
					.prepareStatement("SELECT id FROM pracownik WHERE imie = ?");

			findPracownikByNazwiskoStmt = conn
					.prepareStatement("SELECT id FROM pracownik WHERE nazwisko = ?");
			
			findPracownikByNazwaPizzeriiStmt = conn
					.prepareStatement("SELECT id FROM pracownik WHERE nazwaPizzerii = ?");

			deletePracownikStmt = conn
					.prepareStatement("DELETE FROM pracownik WHERE id = ?");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addPracownik(Pracownik pracownik) {
		try {
			addPracownikStmt.setString(1, pracownik.getImie());
			addPracownikStmt.setString(2, pracownik.getNazwisko());
			addPracownikStmt.setString(3, pracownik.getNazwaPizzerii());
			addPracownikStmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Pracownik> getAllPracownik() {
		List<Pracownik> PracownikList = new ArrayList<Pracownik>();

		try {
			ResultSet rs = getPracownikStmt.executeQuery();

			while (rs.next()) {
				PracownikList.add(new Pracownik(rs.getString("imie"), rs
						.getString("nazwisko"), rs
						.getString("nazwaPizzerii")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return PracownikList;
	}

	public void deleteAllPracownik() {
		try {
			deleteAllPracownikStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> findPracownikByImie(String imie) {
		try {
			List<Integer> result = new ArrayList<Integer>();
			findPracownikByImieStmt.setString(1, imie);
			ResultSet rs = findPracownikByImieStmt.executeQuery();
			while (rs.next())
				result.add(rs.getInt("ID"));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> findPracownikByNazwisko(String nazwisko) {
		try {
			List<Integer> result = new ArrayList<Integer>();
			findPracownikByNazwiskoStmt.setString(1, nazwisko);
			ResultSet rs = findPracownikByNazwiskoStmt.executeQuery();
			while (rs.next())
				result.add(rs.getInt("ID"));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> findPracownikByNazwaPizzerii(String nazwaPizzerii) {
		try {
			List<Integer> result = new ArrayList<Integer>();
			findPracownikByNazwaPizzeriiStmt.setString(1, nazwaPizzerii);
			ResultSet rs = findPracownikByNazwaPizzeriiStmt.executeQuery();
			while (rs.next())
				result.add(rs.getInt("ID"));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deletePracownik(List<Integer> list) {
		try {
			for (Integer id : list) {
				deletePracownikStmt.setInt(1, id);
				deletePracownikStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
	
