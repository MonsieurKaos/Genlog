package singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class EditorGui implements ActionListener {

	private JTextField m_ctrl;
	private Stock m_stock;

	public EditorGui(Stock _stock) {
		m_stock = _stock;
		JFrame frame = new JFrame("Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ctrl = new JTextField(20);
		m_ctrl.addActionListener(this);
		frame.add(m_ctrl);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m_stock.addString(m_ctrl.getText());
		m_stock.display();
		m_ctrl.setText("");
	}
}
