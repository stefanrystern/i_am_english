package textUtils;

import dataStructure.Phrase;
import dataStructure.RDF;

import java.util.ArrayList;

/**
 * Created by Yevhenii on 02.11.2015.
 */
public class RDFGenerator {

    public static ArrayList<RDF> generateRDF(ArrayList<Phrase> phrases){
        ArrayList<RDF> result = new ArrayList<>();
        String entity="";
        String attribure="";
        String value="";
        boolean sameNoun = true;
        for(Phrase phrase : phrases){
            String pos = phrase.getDescription().split(" ")[0];
            if (pos.equals("noun")||pos.equals("unknown_entity")||pos.equals("pronoun")||pos.equals("definite")||pos.equals("preposition")) {
                if (sameNoun==true) {
                    entity += phrase.getValue() + "[" + phrase.getAdditionalLink() + "] ";
                } else {
                    entity = phrase.getValue() + "[" + phrase.getAdditionalLink()+"] ";
                    sameNoun = true;
                }
            }

            if (pos.equals("verb")) {
                attribure="action";
                value=phrase.getValue()+" "+phrase.getAdditionalLink();
                result.add(new RDF(entity, attribure, value));
                sameNoun = false;
            }

            if (pos.equals("adjective")) {
                attribure="property";
                value=phrase.getValue()+" "+phrase.getAdditionalLink();
                result.add(new RDF(entity, attribure, value));
                sameNoun = false;
            }
        }

        for (RDF rdf : result){
            System.out.println(rdf.toString());
        }
        return result;
    }
}
