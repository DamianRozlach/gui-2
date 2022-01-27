import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Okno dodawania nowej ksiazki
class BookDialog extends JDialog {

	private static final long serialVersionUID = 8092551044456132035L;
	private Biblioteka bib;
	
    public BookDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //tytul

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel title = new JLabel("Tytuł:");
        title.setFont(new Font("Serif", Font.BOLD, 12));
        title.setAlignmentX(0.5f);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField titleTextField = new JTextField(20);
        add(titleTextField);

        //autor
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel autor = new JLabel("Autor:");
        autor.setFont(new Font("Serif", Font.BOLD, 12));
        autor.setAlignmentX(0.5f);
        add(autor);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField autorTextField = new JTextField(20);
        add(autorTextField);

        //numer isbn
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel isbn = new JLabel("isbn:");
        isbn.setFont(new Font("Serif", Font.BOLD, 12));
        isbn.setAlignmentX(0.5f);
        add(isbn);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField isbnTextField = new JTextField(20);
        add(isbnTextField);

        //liczba egzemplarzy

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel bookQuantity = new JLabel("Ilosc sztuk:");
        bookQuantity.setFont(new Font("Serif", Font.BOLD, 12));
        bookQuantity.setAlignmentX(0.5f);
        add(bookQuantity);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField quantityTextField = new JTextField(20);
        add(quantityTextField);

        //przyciski

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Dodaj");
        
        // Akcja podpieta pod przycisk "Dodaj"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.dodajKsiazke(new Ksiazka(autorTextField.getText(), titleTextField.getText(), isbnTextField.getText(),Integer.parseInt(quantityTextField.getText())));
                dispose();
            }
        });

        addButton.setAlignmentX(0.5f);
        add(addButton);
        
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

        setTitle("Dodaj ksiazke");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 320);
    }
}
