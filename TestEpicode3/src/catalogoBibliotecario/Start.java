package catalogoBibliotecario;

import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;

public class Start {

	public static void main(String[] args) {
		Publication prova = new Book("978-88-89637-15-9", "Harry potter	", 1994, 321, "J.K.Rowling", "Romanzo");
		Publication prova3 = new Book("888-88-85637-15-9", "Twilitgh	", 2016, 112, "Sthepen Ahwking", "Fantascienza");
		Publication prova4 = new Book("887-88-85637-15-9", "Oliver Twist	", 1956, 24, "Sthepen Ahwking", "Avventura");
		Publication prova5 = new Book("886-88-85637-15-9", "Orgoglio e pregiudizio", 1934, 1312, "Sthepen Ahwking", "Romanzo Storico");
		Publication prova6 = new Book("885-88-85637-15-9", "Addestrare i cani", 1998, 274, "Sthepen Ahwking", "Didattico");
		Publication prova7 = new Magazines("978-84-89637-666", "Naruto		", 1998, 268, "SEMESTRALE");
		Publication prova8 = new Magazines("978-85-89637-666", "Shippuden	", 1998, 126, "MENSILE");
		Publication prova9 = new Magazines("978-86-89637-666", "Batman		", 1998, 48, "SETTIMANALE");
		Publication prova2 = new Magazines("978-88-89637-666", "Superman	", 1998, 68, "SETTIMANALE");
		// System.out.println(prova.toString());
		// System.out.println(prova2.toString());

		Catalog lib = new Catalog();
		lib.insertPublication(prova2);
		lib.insertPublication(prova3);
		lib.insertPublication(prova);
		lib.insertPublication(prova4);
		lib.insertPublication(prova5);
		lib.insertPublication(prova6);
		lib.insertPublication(prova7);
		lib.insertPublication(prova8);
		lib.insertPublication(prova9);

		
		Catalog cat = new Catalog();
		try {
			//Salvataggio su file taxi
			lib.exportCatalog("taxi");
			//Import da file prova
			cat = Catalog.importCatalog("prova");
		} catch (IOException e) {
			e.printStackTrace();
		}
		lib.printCatalog();
		System.out.println();
		System.out.println("Pubblicazione cercata:");
		Publication cercata = lib.getPublication("978-88-89637-666");
		System.out.println(cercata.info());
		System.out.println();
		
		Catalog searchAutor = lib.searchAuthor("Sthepen Ahwking");
		System.out.println("Filtro Autore:");
		searchAutor.printCatalog();
		
		Catalog searchYear = lib.searchYear(1998);
		System.out.println();
		System.out.println("Filtro Anno");
		searchYear.printCatalog();
		lib.removePublication("978-88-89637-15-9");
		lib.removePublication("978-88-89637-666");
		System.out.println();
		System.out.println("Catalogo principale post rimozione");
		lib.printCatalog();
		System.out.println();
		System.out.println("Letto da File");
		cat.printCatalog();
		try {
			lib.mergeCatalog("prova");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Unito da File(aggiunto un nuovo romanzo scritto solo nel file e reinseriti i due eliminati)");
		lib.printCatalog();

	}

}
