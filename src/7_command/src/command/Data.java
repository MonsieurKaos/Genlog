package command;

public class Data {

	private Integer x;
	private String name = "Nom_par_defaut";

	// Constructeur
	public Data() {
		x = 0;
	}

	public void rename(String _new_name) {
		name = _new_name;
	}

	public String getName() {
		return name;
	}

	public void add(int _operande) {
		x = x + _operande;
	};

	public void sub(int _operande) {
		x = x - _operande;
	};

	public Integer getValue() {
		return x;
	}

}
