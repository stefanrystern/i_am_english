package textUtils;

import java.util.ArrayList;

public class SmartSplit {
	
	public ArrayList<String> splitSentenceToPhrasesSmart(String sentence){
		ArrayList<String> resultPhrases = new ArrayList<String>();
		
		int endIndex = 0;
		
		while(true){
			if(sentence.length()==0)break;
			endIndex = nextBreakerIndex(sentence);
			resultPhrases.add(sentence.substring(0,endIndex));
			sentence = sentence.substring(endIndex+1).trim();
		}
		
		return resultPhrases;
	}
	
	private int nextBreakerIndex(String sentence){
		int result=sentence.length();
		
		String[] breakers = {" ",".",","};
		
		for(String breaker: breakers){
			int breakersIndex = sentence.indexOf(breaker);
			if(breakersIndex<result && breakersIndex>0)result = sentence.indexOf(breaker);
		}

		return result;
	}

}
