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

// Okno wypozyczania
class RemoveBookDialog extends JDialog {

	private static final long serialVersionUID = -2626991721261309951L;
	private Biblioteka bib;
	
    public RemoveBookDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Ksiazki:");
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

      

        JButton removeBookButton = new JButton("Usun książke");
        
        // Akcja podpieta pod przycisk "usun książke"
        removeBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.usunKsiazke(bib.getKsiazki().get(booksComboBox.getSelectedIndex()));
                dispose();
            }
        });

        removeBookButton.setAlignmentX(0.5f);
        add(removeBookButton);
        
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

        setTitle("Usun Książkę");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
