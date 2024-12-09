import  util.DatabaseUtil;
import  java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Mendapatkan koneksi ke database
            connection = DatabaseUtil.getConnection();
            System.out.println("Koneksi berhasil!");

            // Lakukan operasi database di sini

        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        } finally {
            // Menutup koneksi
            DatabaseUtil.closeConnection(connection);
        }
        System.out.printf("Hello and welcome!");


    }
}