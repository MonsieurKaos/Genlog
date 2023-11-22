package observer;

import java.util.ArrayList;
import java.util.List;

public class Data {

	private DisplayGui gui;
	private List<String> strings = new ArrayList<String>();

	public Data(DisplayGui _gui) {
		gui = _gui;
	}

	public void addString(String val) {
		strings.add(val);
		gui.display(this);
	}

	public List<String> getStrings() {
		return strings;
	}
}
