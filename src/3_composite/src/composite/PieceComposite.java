package composite;

import java.util.ArrayList;
import java.util.List;

public class PieceComposite {
	/** constructeur */
	public PieceComposite(String _nom, float _cout) {
		m_nom = _nom;
		m_prixAssemblage = _cout;
	}

	/** getter */
	public String getNom() {
		return m_nom;
	}

	/** ajout d'une piece de base */
	public void addPieceBase(PieceDeBase _object) {
		m_compositionPiecesBase.add(_object);
	}

	/** ajout d'une pièce composite */
	public void addPieceComposite(PieceComposite _object) {
		m_compositionPiecesComposite.add(_object);
	}

	/** calcul du prix de la pièce composite */
	public float calculPrix() {
		float prixTotal = 0;
		// Somme des prix des pièces de base
		for (PieceDeBase p : m_compositionPiecesBase) {
			prixTotal += p.getPrix();
		}
		// Somme des prix des pièces composites
		for (PieceComposite p : m_compositionPiecesComposite) {
			prixTotal += p.calculPrix();
		}
		// Ajout du coût d'assemblage
		prixTotal = prixTotal + m_prixAssemblage;
		return prixTotal;
	}

	/** nom de la pièce composite */
	private String m_nom;
	/** son prix d'assemblage */
	private float m_prixAssemblage;
	/** sa composition en pièces de base */
	private List<PieceDeBase> m_compositionPiecesBase = new ArrayList<PieceDeBase>();
	/** sa composition en pièces composites */
	private List<PieceComposite> m_compositionPiecesComposite = new ArrayList<PieceComposite>();
}
