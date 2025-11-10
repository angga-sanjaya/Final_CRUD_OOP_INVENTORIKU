package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Kelas untuk mengatur koneksi ke database MySQL.
 */
public class Koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/crud_oop_202457201012";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection koneksiDatabase;

    public static Connection getKoneksi() {
        try {
            if (koneksiDatabase == null || koneksiDatabase.isClosed()) {
                koneksiDatabase = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi berhasil!");
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return koneksiDatabase;
    }
}
