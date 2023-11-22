package decorator;

public class Window extends Piece {

	private float prixEncadrement = 30;
	private float prixVitreUnitaire = 5;
	private int m_nbVitres = 1;

	public Window(int _nb_vitre) {
		m_nbVitres = _nb_vitre;
	}

	public String getDetails() {
		return "Fenetre " + Integer.toString(m_nbVitres) + " vitres (" + Float.toString(computePrice()) + " euros)";
	}

	public float computePrice() {
		return prixEncadrement + m_nbVitres * prixVitreUnitaire;
	}
}
