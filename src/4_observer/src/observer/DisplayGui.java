package observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DisplayGui {

	private JTextArea textArea;

	public DisplayGui() {
		JFrame frame = new JFrame("Display");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea = new JTextArea(20, 20);
		textArea.setEditable(false);
		frame.add(textArea);

		frame.pack();
		frame.setVisible(true);
	}

	public void display(Data _data) {
		textArea.setText("");
		for (String s : _data.getStrings()) {
			textArea.append(s);
			textArea.append("\n");
		}
	}
}
