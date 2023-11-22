package factorymethod;

import java.util.ArrayList;
import java.util.List;

public class PieceComposite extends Piece {

	// composition de la pièce
	private List<Piece> composition = new ArrayList<Piece>();

	// prix de la pièce
	private float prixAssemblage;

	// constructeur
	public PieceComposite(String nom, float cout) {
		super(nom);
		prixAssemblage = cout;
	};

	// ajout d'une pièce à la composition
	public void add(Piece piece) {
		composition.add(piece);
	}

	// calcul du prix de la composition
	public float calculerPrix() {
		float prixTotal = prixAssemblage;
		for (Piece p : composition) {
			prixTotal += p.calculerPrix();
		}
		return prixTotal;
	};

}
