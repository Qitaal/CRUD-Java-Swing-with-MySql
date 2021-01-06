package formsiswa.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class NorthPanel extends JPanel{
    
    private JLabel lTitle;
    
    public NorthPanel() {
        this.setLayout(new FlowLayout(1));
        
        lTitle = new JLabel("FORM SISWA");
        lTitle.setFont(new Font("SansSerif", Font.BOLD, 32));
        lTitle.setBorder(null);
        lTitle.setOpaque(false);
        this.add(lTitle, FlowLayout.LEFT);
    }
}
