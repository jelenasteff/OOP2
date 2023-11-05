package rs.ac.ni.pmf.oop2;
public class TextParser {
	Encoder encoder; // interfejs
	Storage store; // interfejs

	// setter
	public void setEncoder(Encoder encoder) {
		this.encoder = encoder; // this -> pokazivac na trenutni objekat
	}

	public void setStorage(Storage store) {
		this.store = store;
	}

	public String parse(String text) {
		String trimmed = text.trim();
		String encoded = encoder.encode(trimmed);
		store.store(encoded);
		return encoded;
	}
}