package observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class EditorGui implements ActionListener {
	private JTextField m_ctrl;
	private Data m_data;

	public EditorGui(Data _data) {
		m_data = _data;
		JFrame frame = new JFrame("Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ctrl = new JTextField(20);
		m_ctrl.addActionListener(this);

		frame.add(m_ctrl);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		m_data.addString(m_ctrl.getText());
		m_ctrl.setText("");
	}
}
