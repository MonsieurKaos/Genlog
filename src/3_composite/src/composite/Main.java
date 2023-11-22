
package composite;

public class Main {

	public static void main(String[] args) {

		// Stock manager instanciation
		StockManager stock = new StockManager();
		// Pieces simples
		PieceDeBase pieceA = new PieceDeBase("A", 10);
		PieceDeBase pieceB = new PieceDeBase("B", 20);

		// Pieces composites, incluant notamment un composite (pieceF)
		PieceComposite pieceC = new PieceComposite("C", 100);
		pieceC.addPieceBase(new PieceDeBase("D", 10));
		pieceC.addPieceBase(new PieceDeBase("E", 10));

		PieceComposite pieceF = new PieceComposite("F", 50);
		pieceF.addPieceBase(new PieceDeBase("G", 10));
		pieceF.addPieceBase(new PieceDeBase("H", 20));
		pieceC.addPieceComposite(pieceF);

		// Enregistrement dans le stock
		stock.addPieceBase(pieceA);
		stock.addPieceBase(pieceB);
		stock.addPieceComposite(pieceC);

		// Stock manager: contents
		System.out.println("Etat du stock\n" + stock.toString());
		System.out.println("Valeur totale du stock: " + stock.getPrix());

	}
}