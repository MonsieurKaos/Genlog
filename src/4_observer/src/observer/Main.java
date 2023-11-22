package observer;

public class Main {

	public static void main(String[] args) {
		DisplayGui gui = new DisplayGui();
		Data data = new Data(gui);
		new EditorGui(data);
	}
}
