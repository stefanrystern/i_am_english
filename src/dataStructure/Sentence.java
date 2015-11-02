package dataStructure;

import java.util.ArrayList;

import textUtils.SmartSplit;
import webUtils.ConceptnetParser;

public class Sentence {

	private ArrayList<Phrase> phrases = new ArrayList<Phrase>();
	private String sentence;
	
	public Sentence(String notParsedSentence){
		sentence=notParsedSentence;
		
		SmartSplit ss = new SmartSplit();
		ArrayList<String> words = ss.splitSentenceToPhrasesSmart(sentence);
		
		ConceptnetParser cp = new ConceptnetParser();
		
		for(String word : words){
			phrases.add(cp.identifyWord(word));
		}
		
	}

	@Override
	public String toString() {
		return "Sentence [phrases=" + phrases + "]";
	}
	
	
}
