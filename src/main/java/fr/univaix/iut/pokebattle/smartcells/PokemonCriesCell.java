package fr.univaix.iut.pokebattle.smartcells;


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
    		return "Sala Sala, Salamèèèèèèche";
    	}
    	return null ;
    	}
}
