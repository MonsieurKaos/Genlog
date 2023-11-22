package decorator;

abstract public class Piece {

	// To be implemented by inherited classes to compute their specific price,
	// regardless options
	abstract public float computePrice();

	// To be implemented by inherited classes to retrieve details (i.e. name,
	// specific properties,..)
	abstract public String getDetails();

	// Attributes dedicated to color option
	private boolean m_isColorOptionAdded = false;
	private float m_colorOptionPrice = 10;

	// Attributes dedicated to wood option
	private boolean m_isWoodOptionAdded = false;
	private float m_woodOptionMaterialPrice = 20;
	private float m_woodOptionMountingPrice = 30;

	public Piece() {
	}

	// Add color option, including specific properties used to compute price
	public void addColorOption(float _price) {
		m_isColorOptionAdded = true;
		m_colorOptionPrice = _price;
	}

	// Add wood option, including specific properties used to compute price
	// public void addWoodOption(float _materialPrice = 20,float _mountingPrice =
	// 30)
	public void addWoodOption(float _materialPrice, float _mountingPrice) {
		m_isWoodOptionAdded = true;
		m_woodOptionMaterialPrice = _materialPrice;
		m_woodOptionMountingPrice = _mountingPrice;
	}

	// Compute price resulting from options, adding specific price (computePrice()
	// method)
	public float computeFullPrice() {
		float fullPrice = 0;
		if (m_isColorOptionAdded) {
			fullPrice += m_colorOptionPrice;
		}
		if (m_isWoodOptionAdded) {
			fullPrice += (m_woodOptionMaterialPrice + m_woodOptionMountingPrice);
		}
		return fullPrice + this.computePrice();
	}

	// Compute price resulting from options, adding specific price (computePrice()
	// method)
	public String getFullDetails() {
		String optionsDetails = "";
		if (m_isColorOptionAdded) {
			optionsDetails += " + option color (" + Float.toString(m_colorOptionPrice) + " euros)";
		}
		if (m_isWoodOptionAdded) {
			optionsDetails += " + option wood (" + Float.toString(m_woodOptionMaterialPrice + m_woodOptionMountingPrice)
					+ " euros)";
		}

		return this.getDetails() + optionsDetails;
	}
}
