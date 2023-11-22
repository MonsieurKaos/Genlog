package factorymethod;

abstract public class Piece {

	// nom de la pièce
	private String name;

	// constructeur
	public Piece(String nom) {
		this.name = nom;
	};

	// calcul du prix de la pièce
	abstract public float calculerPrix();

	// getters et setters
	public String getName() {
		return name;
	}

	// affichage pièce
	public String toString() {
		return String.format("Piece : %s, Prix : %f", name, calculerPrix());
	}
}
