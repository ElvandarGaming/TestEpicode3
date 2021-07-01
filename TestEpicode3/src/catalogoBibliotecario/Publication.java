package catalogoBibliotecario;

public abstract class Publication {

	protected String codiceISBN;
	protected String titolo;
	protected int annoPubblicazione;
	protected int numeroPagine;

	public Publication(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return codiceISBN + "@" + titolo + "@" + annoPubblicazione + "@" + numeroPagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public String info() {
		return "ISBN " + codiceISBN + " 	Titolo: " + titolo + " 		Anno Pubb.: " + annoPubblicazione
				+ "	Numero Pagine: " + numeroPagine;
	}

}
