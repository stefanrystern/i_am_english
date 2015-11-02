package webUtils;

import dataStructure.Phrase;

public class ConceptnetParser {
	
	public Phrase identifyWord(String wordToIdentify){
		UrlSource us = new UrlSource();
		String lookUpUrl = "http://conceptnet5.media.mit.edu/web/c/en/" + wordToIdentify.toLowerCase();
		String result = parseSource(us.getUrlSource(lookUpUrl));	
		result = parseResult(result);
		
		return new Phrase(wordToIdentify,result,lookUpUrl);
		
	}
	
	private String parseSource(String sourceToParse){
		if(sourceToParse.contains("No results found for"))return "No results found";
		sourceToParse = sourceToParse.substring(sourceToParse.indexOf("<div class=\"paraphrase\">"));
		sourceToParse = sourceToParse.substring(sourceToParse.indexOf("\n"),sourceToParse.indexOf("</div>")).trim();

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
