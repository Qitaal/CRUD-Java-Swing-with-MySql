package formsiswa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class SiswaTableModel extends AbstractTableModel{

    public final String[] HEADER = {"nis", "nama", "jurusan", "jk", "alamat"};
    List<Siswa> listSiswa;

    public SiswaTableModel() {
        this.listSiswa = new ArrayList<>();
    }
    
    public void resetData(List<Siswa> listSiswa){
        this.listSiswa = listSiswa;
        fireTableDataChanged();
    }
    
    public Siswa getSiswa(int index){
        return listSiswa.get(index);
    }
    
    @Override
    public int getRowCount() {
        return listSiswa.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int i) {
        return HEADER[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Siswa siswa = listSiswa.get(rowIndex);
        
        switch(columnIndex){
            case 0: return siswa.getNis();
            case 1: return siswa.getNama();
            case 2: return siswa.getJurusan();
            case 3: return siswa.getJk();
            case 4: return siswa.getAlamat();
            default: return null;
        }
    }
    
}
