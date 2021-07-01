package catalogoBibliotecario;

public class Book extends Publication {

	private String autore;
	private String genere;

	public Book(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return super.toString() + "@" + autore + "@" + genere;
	}

	@Override
	public String info() {
		return super.info() + "	Autore: " + autore + "	Genere: " + genere;
	}

	public static Publication fromString(String s) {
		String[] p = s.split("@");
		Publication rest = new Book(p[0], p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3]), p[4], p[5]);
		return rest;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

}
