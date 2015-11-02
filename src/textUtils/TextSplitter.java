package textUtils;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

public class TextSplitter {
	
	public ArrayList<String> splitIntoSentences(String textToSplit){
		
		ArrayList<String> resultSentences = new ArrayList<String>();
		
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		iterator.setText(textToSplit);
		int start = iterator.first();
		
		for (int end = iterator.next();end != BreakIterator.DONE;start = end, end = iterator.next()){
			resultSentences.add(textToSplit.substring(start,end));
		}
		
		return resultSentences;
		
	}

}
