package main;

import java.util.ArrayList;

import textUtils.SmartSplit;
import textUtils.TextFileReader;
import textUtils.TextSplitter;
import webUtils.ConceptnetParser;


public class Launcher {

	public static void main(String[] args){
		TextFileReader tfr = new TextFileReader();
		
		String textFromFile = tfr.readTextFile("text_one.txt");

		TextSplitter ts = new TextSplitter();
		
		ArrayList<String> splittedText = ts.splitIntoSentences(textFromFile);
		
		SmartSplit ss = new SmartSplit();
		ArrayList<ArrayList<String>> resultWordsOfSentences = new ArrayList<ArrayList<String>>();
		
		for(String sentence : splittedText){
			resultWordsOfSentences.add(ss.splitSentenceToPhrasesSmart(sentence));
		}
		
		System.out.println(resultWordsOfSentences);
		
		
		ConceptnetParser cp = new ConceptnetParser();
		
		for(ArrayList<String> sentence : resultWordsOfSentences){
			for(String word : sentence){
				System.out.println(cp.identifyWord(word).toString());
			}
		}
		
	}

}
