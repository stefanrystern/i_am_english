package dataStructure;

public class Phrase {
	
	private String value;
	private String description;
	private String additionalLink;
	
	public Phrase(String newValue, String newDescription, String newAdditionalLink){
		value = newValue;
		description = newDescription;
		additionalLink = newAdditionalLink;
	}

	@Override
	public String toString() {
		return "\n" + "\n" + value + "\n" + description + "\n" + additionalLink;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdditionalLink() {
		return additionalLink;
	}

	public void setAdditionalLink(String additionalLink) {
		this.additionalLink = additionalLink;
	}
	
	

	
}
