
package composite;

public class PieceDeBase {
	// constructeur
	public PieceDeBase(String _nom, float prix) {
		m_nom = _nom;
		m_prix = prix;
	}

	// getters
	public float getPrix() {
		return m_prix;
	}

	public String getNom() {
		return m_nom;
	}

	// nom de la pi�ce
	private String m_nom;
	// prix de la pi�ce
	private float m_prix;
}
