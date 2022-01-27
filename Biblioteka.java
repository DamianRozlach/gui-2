import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;



// Klasa Biblioteka
public class Biblioteka extends JFrame implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3167090132551198602L;
	// Listy ksiazek, czytelnikow i wypozyczen
	ArrayList<Ksiazka> ksiazki;
	ArrayList<Czytelnik> czytelnicy;
	ArrayList<Wypozyczenie> wypozyczenia;
	long numer_czytelnika;
	
	/**
	 * Konstruktor
	 */
	public Biblioteka() {
		this.ksiazki = new ArrayList<Ksiazka>();
		this.czytelnicy = new ArrayList<Czytelnik>();
		this.wypozyczenia = new ArrayList<Wypozyczenie>();
		this.numer_czytelnika = 1;
		initUI(this);
	}
	// Metoda inicjalizująca GUI
	public final void initUI(final Biblioteka bib) {
		
		// Panel
		JPanel panel = new JPanel();

		// Pole tekstowe
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);
        
        // Dodanie pola tekstowego do panelu
        panel.add(textArea);
        
        // Dodanie panelu do JFrame
        add(panel);
        pack();
        // Pasek menu
        JMenuBar menubar = new JMenuBar();
        // Menu Biblioteka
        JMenu lib = new JMenu("Biblioteka");
        lib.setMnemonic(KeyEvent.VK_B);
        // Pozycja menu: Zakoncz
        JMenuItem eMenuItem = new JMenuItem("Zakoncz");
        eMenuItem.setMnemonic(KeyEvent.VK_Z);
        eMenuItem.setToolTipText("Zakoncz program");
        // Podpiecie akcji pod "Zakoncz"
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
        		System.exit(0);
            }
        });

        // Pozycja menu: Wyswietl czytelnikow
        JMenuItem usersMenuItem = new JMenuItem("Wyswietl czytelnikow");
        usersMenuItem.setMnemonic(KeyEvent.VK_C);
        usersMenuItem.setToolTipText("Wyswietlenie listy czytelnikow");
        // Podpiecie akcji pod "Wyswietl czytelnikow"
        usersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Czytelnik c: czytelnicy) {  
            		textArea.append(c+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Wyswietl ksiazki
        JMenuItem booksMenuItem = new JMenuItem("Wyswietl ksiazki");
        booksMenuItem.setMnemonic(KeyEvent.VK_K);
        booksMenuItem.setToolTipText("Wyswietlenie listy ksiazek");
        // Podpiecie akcji pod "Wyswietl ksiazki"
        booksMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Ksiazka k: ksiazki) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });

        // Pozycja menu: Wyswietl wypozyczenia
        JMenuItem lendsMenuItem = new JMenuItem("Wyswietl wypozyczenia");
        lendsMenuItem.setMnemonic(KeyEvent.VK_Y);
        lendsMenuItem.setToolTipText("Wyswietlenie listy ksiazek");
        // Podpiecie akcji pod "Wyswietl wypozyczenia"
        lendsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Wypozyczenie k: wypozyczenia) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Dodaj nowego czytelnika
        JMenuItem newReaderMenuItem = new JMenuItem("Dodaj nowego czytelnika");
        newReaderMenuItem.setMnemonic(KeyEvent.VK_N);
        // Podpiecie akcji pod "Dodaj nowego czytelnika"
        newReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReaderDialog ad = new ReaderDialog(bib);
                ad.setVisible(true);
            }
        });

        //Pozycja menu: Dodaj nową książkę

        JMenuItem newBookMenuItem = new JMenuItem("Dodaj nową książke");
        newBookMenuItem.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent event){
            BookDialog adb = new BookDialog(bib);
            adb.setVisible(true);
          }
        });
        
        //Pozycja menu: usuń czytelnika
        JMenuItem remUserMenuItem = new JMenuItem("Usuń czytelnika");
        remUserMenuItem.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent event){
            RemoveReaderDialog rrd = new RemoveReaderDialog(bib);
            rrd.setVisible(true);
          }
        });

        //Pozycja menu: usuń książke
        JMenuItem remBookMenuItem = new JMenuItem("Usuń książke");
        remBookMenuItem.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent event){
            RemoveBookDialog rbd = new RemoveBookDialog(bib);
            rbd.setVisible(true);
          }
        });


        // Pozycja menu: Wypozycz ksiazke czytelnikowi
        JMenuItem lendBookMenuItem = new JMenuItem("Wypozycz ksiazke czytelnikowi");
        lendBookMenuItem.setMnemonic(KeyEvent.VK_W);
        // Podpiecie akcji pod "Wypozycz ksiazke czytelnikowi"
        lendBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LendDialog ad = new LendDialog(bib);
                ad.setVisible(true);
            }
        });

        // Pozycja menu: Zwróć książke
        JMenuItem returnBookMenuItem = new JMenuItem("Zwróc ksiązke");
        returnBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                RemoveLendDialog ad = new RemoveLendDialog(bib);
                ad.setVisible(true);
            }
        });

        //Pozycja menu: Pokaz informacje o koncie
        JMenuItem infoReaderMenuItem = new JMenuItem("Informacje o koncie");
        infoReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                InfoReaderDialog ad = new InfoReaderDialog(bib,textArea);
                ad.setVisible(true);
            }
        });

        //Pozycja menu: Pokaz informacje o ksiazce 
        JMenuItem infoBookMenuItem = new JMenuItem("Informacje o książce");
        infoBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                InfoBookDialog ad = new InfoBookDialog(bib,textArea);
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji do menu "Biblioteka"
        lib.add(lendBookMenuItem);
        lib.add(returnBookMenuItem);
        lib.addSeparator();
        lib.add(newReaderMenuItem);
        lib.add(newBookMenuItem);
        lib.addSeparator();
        lib.add(remUserMenuItem);
        lib.add(remBookMenuItem);
        lib.addSeparator();
        lib.add(usersMenuItem);        
        lib.add(booksMenuItem);
        lib.add(lendsMenuItem);
        lib.addSeparator();
        lib.add(infoReaderMenuItem);
        lib.add(infoBookMenuItem);
        lib.addSeparator();
        lib.add(eMenuItem);
        //Menu Zapisz
        JMenu save =new JMenu("Zapisz/Wczytaj");

        //Pozycja menu Zapisz
        JMenuItem saving = new JMenuItem("Zapisz biblioteke");
        saving.setToolTipText("Zapisuje aktualny biblioteki do plikow, dzieki czemu mozliwe bedzie pozniejsze jego wczytanie poleceniem wczytaj stan biblioteki");
        saving.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              try{
            	  FileOutputStream fos_k = new FileOutputStream("ksiazki.ser");
		            BufferedOutputStream bos_k = new BufferedOutputStream(fos_k);
		            ObjectOutputStream oos_k = new ObjectOutputStream(bos_k);
                oos_k.writeObject(ksiazki);
                oos_k.close();

                FileOutputStream fos_cz = new FileOutputStream("czytelnicy.ser");
		            BufferedOutputStream bos_cz = new BufferedOutputStream(fos_cz);
		            ObjectOutputStream oos_cz = new ObjectOutputStream(bos_cz);
                oos_cz.writeObject(czytelnicy);
                oos_cz.close();

                FileOutputStream fos_w = new FileOutputStream("wypozyczenia.ser");
		            BufferedOutputStream bos_w = new BufferedOutputStream(fos_w);
		            ObjectOutputStream oos_w = new ObjectOutputStream(bos_w);
                oos_w.writeObject(wypozyczenia);
                oos_w.close();
                
                textArea.setText("zapisano stan biblioteki");
              } catch (Exception e) {
                textArea.setText("blad zapisu:"+e);
              }
            }		  
        });

        JMenuItem reading = new JMenuItem("Wczytaj biblioteke");
        reading.setToolTipText("Wczytuje ostatnio zapisany stan biblioteki");
        reading.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              try{
            	  FileInputStream fis_k = new FileInputStream("ksiazki.ser");
		            BufferedInputStream bis_k = new BufferedInputStream(fis_k);
		            ObjectInputStream ois_k = new ObjectInputStream(bis_k);
                setKsiazki((ArrayList<Ksiazka>) ois_k.readObject());
                ois_k.close();

                FileInputStream fis_cz = new FileInputStream("czytelnicy.ser");
		            BufferedInputStream bis_cz = new BufferedInputStream(fis_cz);
		            ObjectInputStream ois_cz = new ObjectInputStream(bis_cz);
                setCzytelnicy((ArrayList<Czytelnik>) ois_cz.readObject());
                ois_cz.close();

                FileInputStream fis_w = new FileInputStream("wypozyczenia.ser");
		            BufferedInputStream bis_w = new BufferedInputStream(fis_w);
		            ObjectInputStream ois_w = new ObjectInputStream(bis_w);
                setWypozyczenia((ArrayList<Wypozyczenie>) ois_w.readObject());
                ois_w.close();

                textArea.setText("wczytano stan biblioteki");
              } catch (Exception e) {
                textArea.setText("blad wczytywania:"+e);
              }
            }		  
        });

        //
        save.add(saving);
        save.add(reading);


        // Menu "Pomoc"
        JMenu help = new JMenu("Pomoc");
        help.setMnemonic(KeyEvent.VK_P);
        
        // Pozycja menu: O programie
        JMenuItem about = new JMenuItem("O programie");
        about.setMnemonic(KeyEvent.VK_O);
        
        // Podpiecie akcji pod "O programie"
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog();
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji "O programie" do menu "Pomoc"
        help.add(about);

        //
        
        // Dodanie menu "Biblioteka" i "Pomoc" do paska menu
        menubar.add(lib);
        menubar.add(save);
        menubar.add(help);

        setJMenuBar(menubar);
        
        setTitle("Biblioteka");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	// Metody get i set
	
	/**
	 * @return the ksiazki
	 */
	public ArrayList<Ksiazka> getKsiazki() {
		return ksiazki;
	}


	/**
	 * @param ksiazki the ksiazki to set
	 */
	public void setKsiazki(ArrayList<Ksiazka> ksiazki) {
		this.ksiazki = ksiazki;
	}

	/**
	 * @return the czytelnicy
	 */
	public ArrayList<Czytelnik> getCzytelnicy() {
		return czytelnicy;
	}

	/**
	 * @param czytelnicy the czytelnicy to set
	 */
	public void setCzytelnicy(ArrayList<Czytelnik> czytelnicy) {
		this.czytelnicy = czytelnicy;
	}

	/**
	 * @return the wypozyczenia
	 */
	public ArrayList<Wypozyczenie> getWypozyczenia() {
		return wypozyczenia;
	}

	/**
	 * @param wypozyczenia the wypozyczenia to set
	 */
	public void setWypozyczenia(ArrayList<Wypozyczenie> wypozyczenia) {
		this.wypozyczenia = wypozyczenia;
	}

  public ArrayList<Ksiazka> borrowedBooks(Czytelnik cz){
    ArrayList<Wypozyczenie> wypozyczenia= getWypozyczenia();
    ArrayList<Ksiazka> wypKsiazki= new ArrayList<Ksiazka>();
    for(int i =0;i<wypozyczenia.size();i++){
      if(wypozyczenia.get(i).getCzytelnik().equals(cz)){
        wypKsiazki.add(wypozyczenia.get(i).getKsiazka());
      }
    }
    return wypKsiazki;

  }

  public ArrayList<Czytelnik> bookReaders(Ksiazka k){
    ArrayList<Wypozyczenie> wypozyczenia= getWypozyczenia();
    ArrayList<Czytelnik> bReader= new ArrayList<Czytelnik>();
    for(int i =0;i<wypozyczenia.size();i++){
      if(wypozyczenia.get(i).getKsiazka().equals(k)){
        bReader.add(wypozyczenia.get(i).getCzytelnik());
      }
    }
    return bReader;

  }

	public long getNumer_czytelnika() {
		return numer_czytelnika;
	}

	public void setNumer_czytelnika(long numer_czytelnika) {
		this.numer_czytelnika = numer_czytelnika;
	}
	
	public long kolejny_numer_czytelnika() {
		return numer_czytelnika++;
	}
	
	public void dodajKsiazke(Ksiazka k) {
		ksiazki.add(k);
	}

	public void dodajCzytelnika(Czytelnik c) {
		czytelnicy.add(c);
	}

	public void dodajWypozyczenie(Wypozyczenie w) {
		wypozyczenia.add(w);
	}

	public void usunKsiazke(Ksiazka k) {
		ksiazki.remove(k);
	}

	public void usunCzytelnika(Czytelnik c) {
		czytelnicy.remove(c);
	}

	public void usunWypozyczenie(Wypozyczenie w) {
    w.getKsiazka().zwroc();
		wypozyczenia.remove(w);
	}
	
	public boolean wypozyczKsiazkeCzytelnikowi(Ksiazka k, Czytelnik c) {
		if (k.wypozycz()) {
			dodajWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
	}

	
}
