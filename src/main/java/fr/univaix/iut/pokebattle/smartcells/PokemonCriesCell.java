package fr.univaix.iut.pokebattle.smartcells;

import twitter4j.Status;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;


/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

    public String ask(Tweet question) {
    	
    	String Tweet = question.getText();
    	
    	if (Tweet.contains("Salut"))
    	{
    		return "Kai Kai, Kaiminuuuuuuus";
    	}
    	return null ;
    	}
}
