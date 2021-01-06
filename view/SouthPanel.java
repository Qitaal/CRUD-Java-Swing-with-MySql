package formsiswa.view;

import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SouthPanel extends JPanel{
    
    JLabel lCreator;
    
    public SouthPanel() {
        this.setLayout(new FlowLayout(1));
        
        lCreator = new JLabel("Created by Thalib Abu Qitaal");
        lCreator.setBorder(null);
        lCreator.setOpaque(false);
        this.add(lCreator, LEFT);
    }
}
