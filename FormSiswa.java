package formsiswa;

import formsiswa.controller.FormController;
import formsiswa.db.Connector;
import formsiswa.db.Database;
import formsiswa.view.CenterPanel;
import formsiswa.view.NorthPanel;
import formsiswa.view.SouthPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class FormSiswa extends JFrame{
      
    public static void main(String[] args) {
        new FormSiswa("FORM SISWA");
    }
    
    public FormSiswa(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 750);
        
        Database database = new Database(new Connector());
        NorthPanel northPanel = new NorthPanel();
        CenterPanel centerPanel = new CenterPanel();
        SouthPanel southPanel = new SouthPanel();
        
        new FormController(database, centerPanel.getFormPanel(), centerPanel.getResultPanel());
        
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(10, 10));
        
        mainContainer.add(northPanel, BorderLayout.NORTH);
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        mainContainer.add(southPanel, BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
