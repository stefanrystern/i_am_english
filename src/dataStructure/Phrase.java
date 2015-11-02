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
		return value + "\n" + description + "\n" + additionalLink + "\n";
	}

	
}
