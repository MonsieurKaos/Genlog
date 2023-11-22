package factorymethod;

public class Main {

	/** Creates a new instance of Main */
	public Main() {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// Stock manager instanciation
		StockManager stock = new StockManager();

		// Pieces simples
		PieceDeBase compteur_1 = new PieceDeBase("Compteur", 10);
		PieceDeBase compteur_2 = new PieceDeBase("Compteur", 10);
		PieceDeBase garde_boue_1 = new PieceDeBase("Garde-boue", 20);

		// Piece composite
		PieceComposite velo_1 = new PieceComposite("Velo", 20);
		velo_1.add(new PieceDeBase("Pedalier", 10));
		velo_1.add(new PieceDeBase("Derailleur", 15));

		PieceComposite roue_avant_1 = new PieceComposite("Roue Avant", 20);
		roue_avant_1.add(new PieceDeBase("Pneu", 10));
		roue_avant_1.add(new PieceDeBase("Jante", 15));

		PieceComposite roue_arriere_1 = new PieceComposite("Roue Arriere", 20);
		roue_arriere_1.add(new PieceDeBase("Pneu", 10));
		roue_arriere_1.add(new PieceDeBase("Jante", 15));

		velo_1.add(roue_avant_1);
		velo_1.add(roue_arriere_1);

		// Enregistrement dans le stock
		stock.add(velo_1);
		stock.add(compteur_1);
		stock.add(compteur_2);
		stock.add(garde_boue_1);

		// Stock manager: contents
		stock.toString();
		System.out.println("Valeur totale du stock: " + stock.getPrix());

		EditorGui editor = new EditorGui(stock);
	}
}
