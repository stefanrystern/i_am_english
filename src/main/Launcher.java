package main;

import java.util.ArrayList;

import dataStructure.Phrase;
import dataStructure.Sentence;
import textUtils.SmartSplit;
import textUtils.TextFileReader;
import textUtils.TextSplitter;
import webUtils.ConceptnetParser;


public class Launcher {

	public static void main(String[] args){
		TextFileReader tfr = new TextFileReader();
		
		String textFromFile = tfr.readTextFile("text_one.txt");

		TextSplitter ts = new TextSplitter();
		
		ArrayList<Sentence> splittedText = ts.splitIntoSentences(textFromFile);
		
		System.out.println(splittedText);
	}

}
