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
class InfoBookDialog extends JDialog {

	private static final long serialVersionUID = -3626991721261309951L;
	private Biblioteka bib;
	
    public InfoBookDialog(Biblioteka bib,JTextArea textArea) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Książki:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
        booksComboBox.setSelectedIndex(-1);
        booksComboBox.setPreferredSize(new Dimension(450, 22));
        booksComboBox.setMaximumSize(new Dimension(450, 22));
        add(booksComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 10)));

      

        JButton infoBookButton = new JButton("Pokaz czytelników");
        
        // Akcja podpieta pod przycisk "pokaz wypozyczenia"
        infoBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              InfoBookResult ibr = new InfoBookResult(bib,bib.getKsiazki().get(booksComboBox.getSelectedIndex()));
              ibr.setVisible(true);
              
                //dispose();
            }
        });

        infoBookButton.setAlignmentX(0.5f);
        add(infoBookButton);
        
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

        setTitle("Informacje o ksiazce");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
