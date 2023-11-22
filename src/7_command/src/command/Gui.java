package command;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui implements ActionListener {

	/// Interface garphique
	private JLabel m_label_valeur_operande;
	private JLabel m_label_valeur_courante;
	private JTextField m_zoneSaisieOperande;
	private JTextField m_zoneAffichageValeur;
	private JTextField m_zoneSaisieName;
	private JTextField m_zoneAffichageName;
	private JButton m_add;
	private JButton m_sub;
	private JButton m_undo;
	private JButton m_redo;
	private JButton m_showHistory;

	// Données manipulées
	private Data m_data;

	// Historique (operations: added (0) or substracted (1))
	private List<Integer> m_operations;
	private List<Integer> m_parameters;
	private Integer m_historyIndex;

	// Constructeur
	Gui() {
		m_data = new Data();
		m_operations = new ArrayList<Integer>();
		m_parameters = new ArrayList<Integer>();
		m_historyIndex = 0;

		// Initialisation elements IHM
		m_label_valeur_operande = new JLabel("Valeur op�rande :");
		m_zoneSaisieOperande = new JTextField(20);
		m_label_valeur_courante = new JLabel("Valeur courante :");
		m_zoneAffichageValeur = new JTextField(20);
		m_zoneAffichageValeur.setEditable(false); // Pour eviter d'ecrire
		m_zoneAffichageValeur.setText(m_data.getValue().toString());

		// Initialisation elements IHM NAME
		m_zoneSaisieName = new JTextField(20);
		m_zoneAffichageName = new JTextField(20);
		m_zoneAffichageName.setEditable(false); // Pour eviter d'ecrire
		m_zoneAffichageName.setText(m_data.getName());

		// Bouton
		m_add = new JButton("+");
		m_add.addActionListener(this);
		m_sub = new JButton("-");
		m_sub.addActionListener(this);

		m_undo = new JButton("Undo");
		m_undo.addActionListener(this);
		m_redo = new JButton("Redo");
		m_redo.addActionListener(this);

		m_showHistory = new JButton("Show History");
		m_showHistory.addActionListener(this);

		// Initialisation du panel dans lequel les elements sont inseres
		JPanel panel = new JPanel();
		panel.add(m_label_valeur_operande);
		panel.add(m_zoneSaisieOperande);
		panel.add(m_label_valeur_courante);
		panel.add(m_zoneAffichageValeur);
		panel.add(m_zoneSaisieName);
		m_zoneSaisieName.addActionListener(this);
		panel.add(m_zoneAffichageName);
		panel.add(m_add);
		panel.add(m_sub);
		panel.add(m_undo);
		panel.add(m_redo);
		panel.add(m_showHistory);

		// Initialisation de la fenetre generale contenant le panel
		JFrame frame = new JFrame("Gui");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its
						// subcomponents.
		frame.setVisible(true); // Shows this Window

	}

	// Callbacks pour les boutons
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m_zoneSaisieName) {
			m_data.rename(m_zoneSaisieName.getText());
			m_zoneSaisieName.setText("");
			m_zoneAffichageName.setText(m_data.getName());
		}
		if (e.getSource() == m_add) {
			this.processAdd();
		} else if (e.getSource() == m_sub) {
			this.processSub();
		} else if (e.getSource() == m_undo) {
			this.processUndo();
		} else if (e.getSource() == m_redo) {
			this.processRedo();
		} else if (e.getSource() == m_showHistory) {
			this.processShowHistory();
		}
		m_zoneAffichageValeur.setText(m_data.getValue().toString());
		m_zoneSaisieOperande.setText("");
	}

	private void processAdd() {
		String valInString = m_zoneSaisieOperande.getText();
		Integer val = Integer.parseInt(valInString);
		m_data.add(val);
		/// Keep history
		m_operations.add(0);
		m_parameters.add(val);
		m_historyIndex = m_parameters.size();
	}

	private void processSub() {
		String valInString = m_zoneSaisieOperande.getText();
		Integer val = Integer.parseInt(valInString);
		m_data.sub(val);
		/// Keep history
		m_operations.add(1);
		m_parameters.add(val);
		m_historyIndex = m_parameters.size();
	}

	private void processUndo() {
		if (m_historyIndex > 0) {
			// Sauvegarde la derniere position de l'historique
			m_historyIndex -= 1;
			// Defait (i.e. fait la réciproque) de la dernière opération
			switch (m_operations.get(m_historyIndex)) {
			case 0:
				System.out.print("undo addition " + m_parameters.get(m_historyIndex).toString() + " \n");
				m_data.sub(m_parameters.get(m_historyIndex));
				break;
			case 1:
				System.out.print("undo soustraction " + m_parameters.get(m_historyIndex).toString() + " \n");
				m_data.add(m_parameters.get(m_historyIndex));
				break;
			}
		}
	}

	private void processRedo() {
		if (m_historyIndex != m_operations.size()) {
			// Sauvegarde la derniere position de l'historique
			m_historyIndex += 1;
			// Fait l'opération associée
			switch (m_operations.get(m_historyIndex - 1)) {
			case 0:
				System.out.print("redo add " + m_parameters.get(m_historyIndex - 1).toString() + " \n");
				m_data.add(m_parameters.get(m_historyIndex - 1));
				break;
			case 1:
				System.out.print("redo substract " + m_parameters.get(m_historyIndex - 1).toString() + " \n");
				m_data.sub(m_parameters.get(m_historyIndex - 1));
				break;
			}
		}
	}

	private void processShowHistory() {
		System.out.print("HISTORIQUE \n");
		for (int i = 0; i < m_operations.size(); i++) {
			Integer currentVal = m_parameters.get(i);
			switch (m_operations.get(i)) {
			case 0:
				System.out.print("(" + i + ") Addition " + currentVal.toString() + "\n");
				break;
			case 1:
				System.out.print("(" + i + ") Soustraction " + currentVal.toString() + "\n");
				break;
			}
		}
		if (m_historyIndex != 0) {
			Integer currentPos = m_historyIndex - 1;
			System.out.print("Position dans l'historique : " + currentPos.toString() + "  \n");
		}
		System.out.print("------------------------------------ \n");
	}

}
