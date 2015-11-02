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
		if(sourceToParse.contains("No results found for"))return "No result";
		sourceToParse=getRelevantData(sourceToParse);
		return removeTags(sourceToParse);
	}
	
	private String removeTags(String stringWithTags){
		String stringWithoutTags = stringWithTags.replaceAll("<(.*?>) ?", " ");
		stringWithoutTags = stringWithoutTags.replaceAll("  ", " ").trim();
		return stringWithoutTags;
	}
	
	private String parseResult(String resultOfLookUp){
		if(resultOfLookUp.contains("is a")){
			resultOfLookUp = resultOfLookUp.substring(resultOfLookUp.indexOf("is a"));
			resultOfLookUp = resultOfLookUp.substring(5);
		}	
		return resultOfLookUp;
	}
	
	private String getRelevantData(String dataToParse){
		dataToParse = dataToParse.substring(dataToParse.indexOf("<div class=\"paraphrase\">"));
		dataToParse = dataToParse.substring(dataToParse.indexOf("\n"),dataToParse.indexOf("</div>")).trim();
		if(dataToParse.length()<1){
			// paraphrase is empty on first concept
		}
		return dataToParse;
	}

}
