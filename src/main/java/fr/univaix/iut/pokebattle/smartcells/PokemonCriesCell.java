package fr.univaix.iut.pokebattle.smartcells;

import twitter4j.Status;
import fr.univaix.iut.pokebattle.SmartCell;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

    public String ask(Status question) {
    	
    	String Tweet = question.getText();
    	
    	if (Tweet.contains("Salut"))
    	{
    		return "Sala Sala, Salamèèèèèèche";
    	}
    	return null ;
    	}


}
