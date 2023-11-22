package factorymethod;

import java.util.ArrayList;
import java.util.List;

public class StockManager {

	// le stock de pièces
	private List<Piece> monStock = new ArrayList<Piece>();

	public String toString() {
		System.out.println("le stock comprend " + this.monStock.size() + " elements:");
		for (Piece p : monStock) {
			// Piece doit implémenter la méthode String toString()
			System.out.println(p);
		}
		return "";
	}

	public float getPrix() {
		float prix_total = 0;
		// pièces de base
		for (Piece p : monStock) {
			prix_total += p.calculerPrix();
		}
		return prix_total;
	}

	// ajout d'une pièce
	public void add(Piece element) {
		monStock.add(element);
	}

}
