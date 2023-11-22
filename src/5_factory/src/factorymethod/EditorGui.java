package factorymethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class EditorGui implements ActionListener {

	EditorGui(StockManager stock) {
		m_stock = stock;
		JFrame frame = new JFrame("Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ctrl = new JTextField(20);
		m_ctrl.addActionListener(this);

		frame.add(m_ctrl);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String NomPieceSaisie = m_ctrl.getText();
		System.out.println("Saisie = " + m_ctrl.getText());
		if (NomPieceSaisie.equals("gb")) {
			PieceDeBase garde_boue = new PieceDeBase("Garde-Boue", 10);
			m_stock.add(garde_boue);
		} else if (NomPieceSaisie.equals("c")) {
			PieceDeBase compteur = new PieceDeBase("Compteur", 20);
			m_stock.add(compteur);
		} else if (NomPieceSaisie.equals("velo")) {
			// Piece composite
			PieceComposite velo = new PieceComposite("Velo", 20);
			velo.add(new PieceDeBase("Pedalier", 10));
			velo.add(new PieceDeBase("Derailleur", 15));

			PieceComposite roue_avant = new PieceComposite("Roue Avant", 20);
			roue_avant.add(new PieceDeBase("Pneu", 10));
			roue_avant.add(new PieceDeBase("Jante", 15));

			PieceComposite roue_arriere = new PieceComposite("Roue Arriere", 20);
			roue_arriere.add(new PieceDeBase("Pneu", 10));
			roue_arriere.add(new PieceDeBase("Jante", 15));

			velo.add(roue_avant);
			velo.add(roue_arriere);

			m_stock.add(velo);
		} else {
			System.out.println("Type de pièce inconnu");
		}
		System.out.println("Etat du stock\n" + this.m_stock);
		System.out.println("Valeur totale du stock: " + this.m_stock.getPrix());

		// Manage TextField modification
		m_ctrl.setText("");
	};

	private JTextField m_ctrl;
	private StockManager m_stock;

}
