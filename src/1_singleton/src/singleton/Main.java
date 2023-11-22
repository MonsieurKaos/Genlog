package singleton;

public class Main {

	public static void main(String[] args) {
		Stock monStock = new Stock();
		new EditorGui(monStock);
		new EditorGui(monStock);
	}
}
