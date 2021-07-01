package catalogoBibliotecario;

public class Magazines extends Publication {

	private Periodicita periodicita;

	public Magazines(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String periodicita) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = Enum.valueOf(Periodicita.class, periodicita);
	}

	@Override
	public String toString() {
		return super.toString() + "@" + periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public static Publication fromString(String s) {
		String[] p = s.split("@");
		Publication rest = new Magazines(p[0], p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3]), p[4]);
		return rest;
	}

	@Override
	public String info() {
		return super.info() + "	Periodicità: " + periodicita;
	}

}
