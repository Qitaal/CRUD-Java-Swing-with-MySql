package formsiswa.view;

import formsiswa.model.Siswa;
import formsiswa.model.SiswaTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.RIGHT;

public class CenterPanel extends JPanel{
    
    public FormPanel formPanel;
    public ResultPanel resultPanel;
    public SiswaTableModel siswaTableModel;
    
    public CenterPanel() {        
        this.setLayout(null);
        
        siswaTableModel = new SiswaTableModel();
        formPanel = new FormPanel();
        resultPanel = new ResultPanel(siswaTableModel);
        formPanel.setBounds(50, 30, 500, 500);
        resultPanel.setBounds(550, 30, 500, 500);
        this.add(formPanel);
        this.add(resultPanel);       
    }

    public FormPanel getFormPanel() {
        return formPanel;
    }

    public ResultPanel getResultPanel() {
        return resultPanel;
    }  
    


    public class FormPanel extends JPanel{
        public int id;
        public JLabel lNis, lNama, lJurusan, lJk, lAlamat;
        public JTextField tfNis, tfNama;
        public JComboBox cbJurusan, cbJk;
        public JTextArea taAlamat;
        public JButton btnSimpan, btnHapus, btnUpdate, btnReset; 

        public final String[] Jurusan = {"Sistem Informasi", "Informatika", "Teknik Industri", "Teknik Kimia", "Teknik Kimia D3"};
        public final String[] JK = {"Laki-Laki", "Perempuan"};

        public FormPanel() {
            this.setLayout(null);

            lNis = new JLabel("NIS", RIGHT);
            lNis.setFont(new Font("SansSerif", Font.PLAIN, 18));
            lNama = new JLabel("Nama", RIGHT);
            lNama.setFont(new Font("SansSerif", Font.PLAIN, 18));
            lJurusan = new JLabel("Jurusan", RIGHT);
            lJurusan.setFont(new Font("SansSerif", Font.PLAIN, 18));
            lJk = new JLabel("JK", RIGHT);
            lJk.setFont(new Font("SansSerif", Font.PLAIN, 18));
            lAlamat = new JLabel("Alamat", RIGHT);
            lAlamat.setFont(new Font("SansSerif", Font.PLAIN, 18));

            tfNis = new JTextField(100);
            tfNama = new JTextField(100);
            cbJurusan = new JComboBox(Jurusan);
            cbJk = new JComboBox(JK);
            taAlamat = new JTextArea(10, 100);
            taAlamat.setLineWrap(true);

            btnSimpan = new JButton("Simpan");
            btnHapus = new JButton("Hapus");
            btnUpdate = new JButton("Update");
            btnReset = new JButton("Reset");

            this.add(lNis);
            this.add(tfNis);
            this.add(lNama);
            this.add(tfNama);
            this.add(lJurusan);
            this.add(cbJurusan);
            this.add(lJk);
            this.add(cbJk);
            this.add(lAlamat);
            this.add(taAlamat);
            this.add(btnSimpan);
            this.add(btnHapus);
            this.add(btnReset);
            this.add(btnUpdate);

            lNis.setBounds(10, 10, 100, 30);
            lNama.setBounds(10, 60, 100, 30);
            lJurusan.setBounds(10, 110, 100, 30);
            lJk.setBounds(10, 160, 100, 30);
            lAlamat.setBounds(10, 210, 100, 30);
            tfNis.setBounds(140, 10, 300, 30);
            tfNama.setBounds(140, 60, 300, 30);
            cbJurusan.setBounds(140, 110, 300, 30);
            cbJk.setBounds(140, 160, 300, 30);
            taAlamat.setBounds(140, 210, 300, 100);

            btnSimpan.setBounds(140, 360, 140, 30);
            btnUpdate.setBounds(140, 410, 140, 30);
            btnHapus.setBounds(300, 360, 140, 30);
            btnReset.setBounds(300, 410, 140, 30);
        }
        
        public String[] getJK() {
            return JK;
        }

        public String[] getJurusan() {
            return Jurusan;
        }
    }

    public class ResultPanel extends JPanel{

        public JTable tblResult;
        public SiswaTableModel siswaTableModel;

        public ResultPanel(SiswaTableModel siswaTableModel){
            this.setLayout(new BorderLayout());

            this.siswaTableModel = siswaTableModel;
            tblResult = new JTable(siswaTableModel);
            tblResult.setBounds(0, 30, 500, 500);
            this.add(tblResult, BorderLayout.CENTER);
            this.add(tblResult.getTableHeader(), BorderLayout.NORTH);
        }
    }
}