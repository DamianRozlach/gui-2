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
class RemoveLendDialog extends JDialog {

	private static final long serialVersionUID = -1626991721261309951L;
	private Biblioteka bib;
	
    public RemoveLendDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Wypozyczenia:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox lendsComboBox = new JComboBox(bib.getWypozyczenia().toArray());
        lendsComboBox.setSelectedIndex(-1);
        lendsComboBox.setPreferredSize(new Dimension(450, 22));
        lendsComboBox.setMaximumSize(new Dimension(450, 22));
        add(lendsComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 10)));

      

        JButton removeLendButton = new JButton("Zwróć książke");
        
        // Akcja podpieta pod przycisk "usun książke"
        removeLendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.usunWypozyczenie(bib.getWypozyczenia().get(lendsComboBox.getSelectedIndex()));
                dispose();
            }
        });

        removeLendButton.setAlignmentX(0.5f);
        add(removeLendButton);
        
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

        setTitle("Zwrot ksiązek");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
