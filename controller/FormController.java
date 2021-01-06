package formsiswa.controller;

import formsiswa.db.Connector;
import formsiswa.db.Database;
import formsiswa.model.Siswa;
import formsiswa.view.CenterPanel;
import formsiswa.view.CenterPanel.FormPanel;
import formsiswa.view.CenterPanel.ResultPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class FormController {
    
    private Database database;
    private FormPanel formPanel;
    private ResultPanel resultPanel;
    
    public FormController(Database database, FormPanel formPanel, ResultPanel resultPanel) {
        this.database = database;
        this.formPanel = formPanel;
        this.resultPanel = resultPanel;
        
        resultPanel.siswaTableModel.resetData(database.getListSiswa());

        formPanel.btnSimpan.addActionListener((ae) -> {
            if(isFormNotComplete())
                JOptionPane.showMessageDialog(formPanel,"Isi semua untuk menyimpan!","Alert",JOptionPane.WARNING_MESSAGE); 
            else
                onSimpan();
        });
        formPanel.btnReset.addActionListener((ae) -> onResetForm());
        formPanel.btnHapus.addActionListener((ae) -> {
            if(formPanel.id != 0){
                onHapus(formPanel.id);
            } else {
                JOptionPane.showMessageDialog(formPanel,"Data belum disimpan. Simpan terlebih dahulu untuk menghapus!","Alert",JOptionPane.WARNING_MESSAGE); 
            }
        });
        formPanel.btnUpdate.addActionListener((ae) -> {
            if(isFormNotComplete())
                JOptionPane.showMessageDialog(formPanel,"Isi semua untuk menyimpan!","Alert",JOptionPane.WARNING_MESSAGE);
            else 
                onUpdate();
        });
        resultPanel.tblResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                onTableItemSelected(resultPanel.siswaTableModel.getSiswa(resultPanel.tblResult.rowAtPoint(me.getPoint())));
            }
        });
    }
    
    boolean isFormNotComplete(){
        if(formPanel.tfNama.getText().equals("") || formPanel.tfNis.getText().equals("") || formPanel.taAlamat.getText().equals(""))
            return true;
        return false;
    }
    
    void onSimpan(){
        Siswa siswa = new Siswa(
            0, 
            formPanel.tfNis.getText().toString().trim(), 
            formPanel.tfNama.getText().toString().trim(), 
            formPanel.getJurusan()[formPanel.cbJurusan.getSelectedIndex()],
            formPanel.getJK()[formPanel.cbJk.getSelectedIndex()],
            formPanel.taAlamat.getText().toString().trim()
        );
        database.insert(siswa);
        resultPanel.siswaTableModel.resetData(database.getListSiswa());
        
        onResetForm();
    }
    
    void onHapus(int id){
        database.delete(id);
        resultPanel.siswaTableModel.resetData(database.getListSiswa());
        
        onResetForm();
    }
    
    void onUpdate(){
        Siswa siswa = new Siswa(
                formPanel.id, 
                formPanel.tfNis.getText().trim(), 
                formPanel.tfNama.getText().toString().trim(), 
                formPanel.getJurusan()[formPanel.cbJurusan.getSelectedIndex()], 
                formPanel.getJK()[formPanel.cbJk.getSelectedIndex()], 
                formPanel.taAlamat.getText().toString().trim()
        );
        database.update(siswa);
        resultPanel.siswaTableModel.resetData(database.getListSiswa());
    }
    
    void onResetForm(){
        formPanel.id = 0;
        formPanel.tfNis.setText("");
        formPanel.tfNama.setText("");
        formPanel.cbJurusan.setSelectedIndex(0);
        formPanel.cbJk.setSelectedIndex(0);
        formPanel.taAlamat.setText("");
    }
    
    void onTableItemSelected(Siswa siswa){
        formPanel.id = siswa.getId();
        formPanel.tfNis.setText(siswa.getNis());
        formPanel.tfNama.setText(siswa.getNama());
        switch(siswa.getJurusan()){
            case "Sistem Informasi":
                formPanel.cbJurusan.setSelectedIndex(0);
                break;
            case "Informatika":
                formPanel.cbJurusan.setSelectedIndex(1);
                break;
            case "Teknik Industri":
                formPanel.cbJurusan.setSelectedIndex(2);
                break;
            case "Teknik Kimia":
                formPanel.cbJurusan.setSelectedIndex(3);
                break;
            case "Teknik Kimia D3":
                formPanel.cbJurusan.setSelectedIndex(4);
                break;
        }
        if(siswa.getJk().equals("Laki-Laki"))
            formPanel.cbJk.setSelectedIndex(0);
        else
            formPanel.cbJk.setSelectedIndex(1);
        formPanel.taAlamat.setText(siswa.getAlamat());
    }
}
