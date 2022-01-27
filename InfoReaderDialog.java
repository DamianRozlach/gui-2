import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.io.Serializable;
import java.util.ArrayList;

// Okno wypozyczania
class InfoReaderDialog extends JDialog {

	private static final long serialVersionUID = -3626991721261309951L;
	private Biblioteka bib;
  private JTextArea textArea;
	
    public InfoReaderDialog(Biblioteka bib,JTextArea textArea) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Czytelnicy:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(bib.getCzytelnicy().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 10)));

      

        JButton infoUserButton = new JButton("Pokaz wypozyczenia");
        
        // Akcja podpieta pod przycisk "pokaz wypozyczenia"
        infoUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              InfoReaderResult irr = new InfoReaderResult(bib,bib.getCzytelnicy().get(readersComboBox.getSelectedIndex()));
              irr.setVisible(true);
              
                //dispose();
            }
        });

        infoUserButton.setAlignmentX(0.5f);
        add(infoUserButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Informacje o koncie");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
