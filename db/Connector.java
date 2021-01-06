package formsiswa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    String DB_URL = "jdbc:mysql://localhost/siswa";
    String DB_USERNAME = "root";
    String DB_PASSWORD = "";
    
    public Connection connection;
    
    public Connector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Koneksi Berhasil");
        }catch(Exception e){
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
    }
}
