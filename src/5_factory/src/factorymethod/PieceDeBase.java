package factorymethod;

public class PieceDeBase extends Piece {

	// prix de la pièce
	private float prixUnitaire;

	// constructeur
	public PieceDeBase(String nom, float prix) {
		super(nom);
		prixUnitaire = prix;
	};

	// calcul du prix de la pièce
	public float calculerPrix() {
		return prixUnitaire;
	};

}
