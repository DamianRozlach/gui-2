import javax.swing.SwingUtilities;
import java.io.IOException;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
      			Biblioteka bib = new Biblioteka();
                bib.dodajCzytelnika(new Czytelnik("Jan", "Kowalski", bib.kolejny_numer_czytelnika()));
                bib.dodajCzytelnika(new Czytelnik("Dariusz", "Malinowski", bib.kolejny_numer_czytelnika()));
                bib.dodajCzytelnika(new Czytelnik("Wojciech", "Kaminski", bib.kolejny_numer_czytelnika()));
                bib.dodajKsiazke(new Ksiazka("D. Thomas", "Programming Ruby 1.9", "978-1-934356-08-1", 5));
                bib.dodajKsiazke(new Ksiazka("J. Loeliger", "Version Control with Git", "978-0-596-52012-0", 2));
                bib.dodajKsiazke(new Ksiazka("J.E.F. Friedl", "Matering Regular Expressions", "978-0-596-52812-6", 1));
                bib.setVisible(true);
            }
        });
	}
}

/*    1 Rozbuduj przykładowy system o następujące elementy:
        1.1 Dodawanie książek.+
        1.2 Usuwanie czytelników.+
        1.3 Usuwanie książek.+
        1.4 Zwrot książki.+
        1.5 Wyświetlanie informacji o koncie czytelnika (o wypożyczonych przez niego książkach).+
        1.6 Wyświetlanie informacji o książce (komu wypożyczono poszczególne egzemplarze).+
    2 Dodaj mechanizm serializacji, tak aby możliwe było odtworzenie stanu systemu po jego ponownym uruchomieniu.+
*/
