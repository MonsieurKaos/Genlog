package decorator;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("PORTE ---------------------------------");
		
		Piece maPorte = new Door();
		System.out.println("maPorte : " + maPorte.getFullDetails() + "\n -> Prix total: " + maPorte.computeFullPrice());
		
		maPorte.addColorOption(10);
		System.out.println("maPorte : " + maPorte.getFullDetails() + "\n -> Prix total: " + maPorte.computeFullPrice());
		
		maPorte.addWoodOption(20, 30);
		System.out.println("maPorte : " + maPorte.getFullDetails() + "\n -> Prix total: " + maPorte.computeFullPrice());

		
		System.out.println("FENETRE ---------------------------------");
		
		Piece maFenetre = new Window(4);
		System.out.println("maFenetre : " + maFenetre.getFullDetails() + "\n -> Prix total: " + maFenetre.computeFullPrice());

		maFenetre.addWoodOption(20, 30);
		System.out.println("maFenetre : " + maFenetre.getFullDetails() + "\n -> Prix total: " + maFenetre.computeFullPrice());

		maFenetre.addColorOption(10);
		System.out.println("maFenetre : " + maFenetre.getFullDetails() + "\n -> Prix total: " + maFenetre.computeFullPrice());
	}
}
