import java.io.Serializable;


public class Ksiazka implements Serializable {
	
	private static final long serialVersionUID = 8250921949882699243L;
	private String autor;
	private String tytul;
	private String isbn;
	private int ilosc_egzemplarzy;
	private int ilosc_wypozyczonych_egzemplarzy;
	
	/**
	 * @param autor
	 * @param tytul
	 * @param isbn
	 */
	public Ksiazka(String autor, String tytul, String isbn, int ilosc_egzemplarzy) {
		super();
		this.autor = autor;
		this.tytul = tytul;
		this.isbn = isbn;
		this.ilosc_egzemplarzy = ilosc_egzemplarzy;
		this.ilosc_wypozyczonych_egzemplarzy = 0;
	}
	
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * @return the tytul
	 */
	public String getTytul() {
		return tytul;
	}
	/**
	 * @param tytul the tytul to set
	 */
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
		
	/**
	 * @return the ilosc_egzemplarzy
	 */
	public int getIlosc_egzemplarzy() {
		return ilosc_egzemplarzy;
	}

	/**
	 * @param ilosc_egzemplarzy the ilosc_egzemplarzy to set
	 */
	public void setIlosc_egzemplarzy(int ilosc_egzemplarzy) {
		this.ilosc_egzemplarzy = ilosc_egzemplarzy;
	}

	/**
	 * @return the ilosc_wypozyczonych_egzemplarzy
	 */
	public int getIlosc_wypozyczonych_egzemplarzy() {
		return ilosc_wypozyczonych_egzemplarzy;
	}

	/**
	 * @param ilosc_wypozyczonych_egzemplarzy the ilosc_wypozyczonych_egzemplarzy to set
	 */
	public void setIlosc_wypozyczonych_egzemplarzy(int ilosc_wypozyczonych_egzemplarzy) {
		this.ilosc_wypozyczonych_egzemplarzy = ilosc_wypozyczonych_egzemplarzy;
	}

	boolean wypozycz() {
		if (ilosc_egzemplarzy - ilosc_wypozyczonych_egzemplarzy > 0) {
			ilosc_wypozyczonych_egzemplarzy += 1;
			return true;
		}
		else
			return false;
	}

  boolean zwroc() {
		if (ilosc_wypozyczonych_egzemplarzy > 0) {
			ilosc_wypozyczonych_egzemplarzy -= 1;
			return true;
		}
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return autor +", " + tytul + " (egz.: " + ilosc_egzemplarzy + ", wyp.:"
				+ ilosc_wypozyczonych_egzemplarzy + ")";
	}
	
}
