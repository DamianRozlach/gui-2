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
class InfoBookResult extends JDialog {

	private static final long serialVersionUID = -3626991721261309951L;
	private Biblioteka bib;
  private int index;
  private Ksiazka ks;
	
    public InfoBookResult(Biblioteka bib,int index,Ksiazka ks) {
    	this.bib = bib;	
      this.index = index;
      this.ks = ks;
        initUI();
    }

    public InfoBookResult(Biblioteka bib,Ksiazka ks) {
    	this.bib = bib;	
      this.index = 0;
      this.ks = ks;
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Ksiazka:"+ks);
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel statement = new JLabel("Wypozyczone przez:");
        statement.setFont(new Font("Serif", Font.BOLD, 12));
        statement.setAlignmentX(0.5f);
        add(statement);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        ArrayList<Czytelnik> czyt = new ArrayList<Czytelnik>();
        czyt=bib.bookReaders(ks);
        String s = new String();
        for(Czytelnik cz: czyt){
          s += cz+"\n";
        }

        JLabel info = new JLabel(s);
        info.setFont(new Font("Serif", Font.BOLD, 12));
        info.setAlignmentX(0.5f);
        add(info);

      

        /* JButton infoUserButton = new JButton("Pokaz wypozyczenia");
        
        // Akcja podpieta pod przycisk "pokaz wypozyczenia"
        infoUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              textArea.setText("Ksiazki wypozyczone przez uzytkownika"+bib.getCzytelnicy().get(readersComboBox.getSelectedIndex()));
              for (Ksiazka k: bib.borrowedBooks(bib.getCzytelnicy().get(readersComboBox.getSelectedIndex()))) {  
            		textArea.append(k+"\n");
              }
                dispose();
            }
        });
        

        infoUserButton.setAlignmentX(0.5f);
        add(infoUserButton);
        */
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton closelButton = new JButton("Zamknij");
        closelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        closelButton.setAlignmentX(0.5f);
        add(closelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Czytelnicy tytułu");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
