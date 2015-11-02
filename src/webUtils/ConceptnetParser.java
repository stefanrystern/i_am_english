package webUtils;

import dataStructure.Phrase;

public class ConceptnetParser {
	
	public Phrase identifyWord(String wordToIdentify){
		UrlSource us = new UrlSource();
		if (wordToIdentify.matches("[a-zA-Z]+")) {
//		String lookUpUrl = "http://conceptnet5.media.mit.edu/web/c/en/" + wordToIdentify.toLowerCase();
			String lookUpUrl = "http://dictionary.reference.com/browse/" + wordToIdentify.toLowerCase() + "?s=t";
			String result = "";
			try {
				result = parseSource(us.getUrlSource(lookUpUrl));
			} catch (Exception ex) {
				result = "unknown_entity";
				lookUpUrl = "https://en.wikipedia.org/wiki/" + wordToIdentify.toLowerCase();
			}
			result = parseResult(result);

			return new Phrase(wordToIdentify, result, lookUpUrl);
		} else return new Phrase(wordToIdentify, "not_word", "");
	}
	
	private String parseSource(String sourceToParse){
//		if(sourceToParse.contains("No results found for"))return "No results found";
//		sourceToParse = sourceToParse.substring(sourceToParse.indexOf("<div class=\"paraphrase\">"));
//		sourceToParse = sourceToParse.substring(sourceToParse.indexOf("\n"),sourceToParse.indexOf("</div>")).trim();
		sourceToParse = sourceToParse.substring(sourceToParse.indexOf("<div class=\"source-data\">"));
		sourceToParse = sourceToParse.substring(sourceToParse.indexOf("<header class=\"luna-data-header\">"), sourceToParse.indexOf("</header>")).trim();
		return removeTags(sourceToParse);
	}
	
	private String removeTags(String stringWithTags){
		String stringWithoutTags = stringWithTags.replaceAll("<(.*?>) ?", " ");
		stringWithoutTags = stringWithoutTags.replaceAll("  ", " ").trim();
		return stringWithoutTags;
	}
	
	private String parseResult(String resultOfLookUp){
		if(resultOfLookUp.contains("is a")){
			return resultOfLookUp.substring(resultOfLookUp.indexOf("is a"));
		}	
		return resultOfLookUp;
	}
}