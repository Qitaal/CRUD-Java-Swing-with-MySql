package formsiswa.db;

import formsiswa.model.Siswa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    public final String COLUMN_ID = "id";
    public final String COLUMN_NIS = "nis";
    public final String COLUMN_NAMA = "nama";
    public final String COLUMN_JURUSAN = "jurusan";
    public final String COLUMN_JK = "jk";
    public final String COLUMN_ALAMAT = "alamat";
    
    Connection connection;

    public Database(Connector connector) {
        this.connection = connector.connection;
    }
    
    
    public List<Siswa> getListSiswa(){
        ArrayList<Siswa> listSiswa = new ArrayList<>();
        String query = "SELECT * FROM info_siswa";
        Statement statement;
        
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                listSiswa.add(new Siswa(
                        resultSet.getInt(COLUMN_ID),
                        resultSet.getString(COLUMN_NIS),
                        resultSet.getString(COLUMN_NAMA),
                        resultSet.getString(COLUMN_JURUSAN),
                        resultSet.getString(COLUMN_JK),
                        resultSet.getString(COLUMN_ALAMAT)                        
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSiswa;
    }
    
    public void insert(Siswa siswa){
        String query = "INSERT INTO info_siswa (" + COLUMN_NIS + ", " + COLUMN_NAMA + ", " + COLUMN_JURUSAN + ", "+ COLUMN_JK + ", " + COLUMN_ALAMAT +") VALUES('" + siswa.getNis() + "', '" + siswa.getNama() + "', '" + siswa.getJurusan() + "', '" + siswa.getJk() + "', '" + siswa.getAlamat() + "')";
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Siswa siswa){
        String query = "UPDATE info_siswa SET " + 
                COLUMN_NIS + "='" + siswa.getNis() + "'," +
                COLUMN_NAMA + "='" + siswa.getNama()+ "'," +
                COLUMN_JURUSAN + "='" + siswa.getJurusan()+ "'," +
                COLUMN_JK + "='" + siswa.getJk() + "'," +
                COLUMN_ALAMAT + "='" + siswa.getAlamat() + "' " +
                " WHERE " + COLUMN_ID + "=" + siswa.getId();
        
        try {
            Statement statement = connection.createStatement();
            statement.executeLargeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        String query = "DELETE FROM info_siswa WHERE " + COLUMN_ID + "=" + id;
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
