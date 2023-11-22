package state;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui implements ActionListener {

	private JButton m_decrocher;
	private JButton m_parler;
	private JButton m_raccrocher;
	private JTextField m_zoneAffichage;
	private Phone m_phone;

	// Constructeur
	Gui(Phone _phone) {
		m_phone = _phone;
		// Initialisation elements IHM
		m_zoneAffichage = new JTextField(20);
		m_zoneAffichage.setText(m_phone.getStateName());
		m_zoneAffichage.setEditable(false); // Pour eviter d'ecrire

		// Bouton
		m_decrocher = new JButton("Décrocher");
		m_decrocher.addActionListener(this);
		m_raccrocher = new JButton("Raccrocher");
		m_raccrocher.addActionListener(this);
		m_parler = new JButton("Parler");
		m_parler.addActionListener(this);

		// Initialisation du panel dans lequel les elements sont inseres
		JPanel panel = new JPanel();
		panel.add(m_decrocher);
		panel.add(m_parler);
		panel.add(m_raccrocher);
		panel.add(m_zoneAffichage);

		// Initialisation de la fenetre generale contenant le panel
		JFrame frame = new JFrame("Gui");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its
						// subcomponents.
		frame.setVisible(true); // Shows this Window

	}

	// Callbacks for buttons: dispatch processings
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m_decrocher) {
			m_phone.decrocher();
		} else if (e.getSource() == m_raccrocher) {
			m_phone.raccrocher();
		} else if (e.getSource() == m_parler) {
			m_phone.parler();
		}
		m_zoneAffichage.setText(m_phone.getStateName());
	}

}
