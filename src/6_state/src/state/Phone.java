package state;

public class Phone {

	enum State {
		DOWN, UP, TALKING
	}

	// Constructeur
	public Phone() {
	}

	public void changeState(State _state) {
		m_state = _state;
	}

	public String getStateName() {
		String stringState = "";
		switch (m_state) {
		case DOWN:
			stringState = "DOWN";
			break;
		case TALKING:
			stringState = "TALKING";
			break;
		case UP:
			stringState = "UP";
			break;
		}
		return "Etat du téléphone : " + stringState;
	}

	public void decrocher() {
		if (m_state == State.DOWN) {
			System.out.println("Vous venez de décrocher ...");
			m_state = State.UP;
		} else {
			if (m_state == State.UP) {
				System.out.println("Le téléphone était déjà décroché : parlez ou bien raccrochez !!!");
			} else if (m_state == State.TALKING) {
				System.out.println("En principe, vous êtes en train de parler, pourquoi redécrochez-vous ? ;-(");
			}
		}
	}

	public void raccrocher() {
		if (m_state == State.TALKING) {
			System.out.println("Vous venez de raccrocher.");
			m_state = State.DOWN;
		} else if (m_state == State.UP) {
			System.out.println("Vous venez de raccrocher sans avoir parler...");
			m_state = State.DOWN;
		} else if (m_state == State.DOWN) {
			System.out.println("Le combiné est déjà raccroché ! Que faites-vous ?");
		}
	};

	public void parler() {
		if (m_state == State.UP) {
			System.out.println("Vous parlez...");
			m_state = State.TALKING;
		} else {
			if (m_state == State.DOWN) {
				System.out.println("Décrochez avant de parler !");
			} else if (m_state == State.TALKING) {
				System.out.println("Vous continuez de parler ...");
			}
		}
	};

	private State m_state = State.DOWN;
}
