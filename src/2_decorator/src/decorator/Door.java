package decorator;

public class Door extends Piece {
	
	private float prixPanneau = 100;
	private float prixSerrure = 10;
	private float prixAssemblage = 5;

	public Door() {
	}

	public String getDetails() {
		return "Porte (" + Float.toString(computePrice()) + " euros)";
	}

	public float computePrice() {
		return prixPanneau + prixSerrure + prixAssemblage;
	}
}
