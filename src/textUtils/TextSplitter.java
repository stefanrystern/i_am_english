package textUtils;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

import dataStructure.Sentence;

public class TextSplitter {
	
	public ArrayList<Sentence> splitIntoSentences(String textToSplit){
		
		ArrayList<Sentence> resultSentences = new ArrayList<Sentence>();
		
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		iterator.setText(textToSplit);
		int start = iterator.first();
		
		for (int end = iterator.next();end != BreakIterator.DONE;start = end, end = iterator.next()){
			resultSentences.add(new Sentence(textToSplit.substring(start,end)));
		}
		
		return resultSentences;
		
	}

}
