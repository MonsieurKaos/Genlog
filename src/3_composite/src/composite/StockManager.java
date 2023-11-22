package composite;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
	// affichage stock
	public String toString() {
		String chaine = "Le stock comprend :\n";
		// pièces de base
		for (PieceDeBase p : m_stockBase) {
			chaine += "Piece " + p.getNom() + " - Prix = " + p.getPrix() + "\n";
		}
		// pièces composites
		for (PieceComposite p : m_stockComposite) {
			chaine += "Piece " + p.getNom() + " - Prix = " + p.calculPrix() + "\n";
		}

		return chaine;
	}

	public float getPrix() {
		float prix_total = 0;
		// pièces de base
		for (PieceDeBase p : m_stockBase) {
			prix_total += p.getPrix();
		}
		// pièces composites
		for (PieceComposite p : m_stockComposite) {
			prix_total += p.calculPrix();
		}
		return prix_total;
	}

	// ajout d'une pièce de base
	public void addPieceBase(PieceDeBase element) {
		m_stockBase.add(element);
	}

	// ajout d'une pièce composite
	public void addPieceComposite(PieceComposite element) {
		m_stockComposite.add(element);
	}

	// stock de pièces de base
	private List<PieceDeBase> m_stockBase = new ArrayList<PieceDeBase>();
	// stock de pièces composites
	private List<PieceComposite> m_stockComposite = new ArrayList<PieceComposite>();
}
