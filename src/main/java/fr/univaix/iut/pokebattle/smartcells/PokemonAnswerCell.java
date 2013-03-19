package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Tweet;
import twitter4j.Status;

public class PokemonAnswerCell {
    public String ask(Tweet question) {
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();
    	
    	if (Tweet.contains("Salut"))
    	{
    		return "@" + Name + " Sala Sala, Salamèèèèèèche";
    	}
    	return null ;
    	}
}
