package catalogoBibliotecario;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Catalog {

	private Map<String, Publication> cat = new HashMap<>();

	public Catalog() {
	}

	public Catalog(Map<String, Publication> imported) {
		cat = imported;
	}

	public void insertPublication(Publication pub) {
		cat.put(pub.getCodiceISBN(), pub);
	}

	public void removePublication(String ISBN) {
		cat.remove(ISBN);
	}

	public Publication getPublication(String ISBN) {
		return cat.get(ISBN);
	}

	public Catalog searchYear(int yea) {

		Map<String, Publication> f = cat.entrySet().stream().map(es -> es.getValue())
				.filter(pub -> pub.getAnnoPubblicazione() == yea)
				.collect(Collectors.toMap(Publication::getCodiceISBN, Function.identity()));
		return new Catalog(f);
	}

	public Catalog searchAuthor(String aut) {

		Map<String, Publication> f = cat.entrySet().stream().map(es -> es.getValue()).filter(pub -> pub instanceof Book)
				.filter(bok -> ((Book) bok).getAutore().equals(aut))
				.collect(Collectors.toMap(Publication::getCodiceISBN, Function.identity()));
		return new Catalog(f);
	}

	public void exportCatalog(String nomeFile) throws IOException {
		String write = cat.entrySet().stream().map(es -> es.getValue()).map(pub -> pub.toString())
				.collect(Collectors.joining("#"));
		File file = new File("outputCatalog/" + nomeFile + ".txt");
		FileUtils.writeStringToFile(file, write, "UTF-8");

	}

	public void mergeCatalog(String nomeFile) throws IOException {
		File file = new File("outputCatalog/" + nomeFile + ".txt");
		String read = FileUtils.readFileToString(file, "UTF-8");
		Map<String, Publication> imported = new HashMap<>();
		imported.putAll(Stream.of(read.split("#"))
				.map(str -> Catalog.whatPublication(str) ? Book.fromString(str) : Magazines.fromString(str))
				.collect(Collectors.toMap(Publication::getCodiceISBN, Function.identity())));
		getCat().putAll(imported);
	}
	
	public static Catalog importCatalog(String nomeFile) throws IOException {
		File file = new File("outputCatalog/" + nomeFile + ".txt");
		String read = FileUtils.readFileToString(file, "UTF-8");
		Map<String, Publication> imported = new HashMap<>();
		imported.putAll(Stream.of(read.split("#"))
				.map(str -> Catalog.whatPublication(str) ? Book.fromString(str) : Magazines.fromString(str))
				.collect(Collectors.toMap(Publication::getCodiceISBN, Function.identity())));
		return new Catalog(imported);
	}

	private static boolean whatPublication(String str) {
		String[] ciccio = str.split("@");
		if (ciccio.length == 6) {
			return true;
		}
		return false;
	}

	public void printCatalog() {
		cat.entrySet().stream().map(es -> es.getValue()).forEach(pub -> System.out.println(pub.info()));
	}
	
	private Map<String, Publication> getCat(){
		return cat;
	}
}
