package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCell implements SmartCell{

	static final int INDEX_DRESS_ADV = 5;
	static final int INDEX_DRESS = 3;
	
	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String tweet = question.getText();
		String juge = question.getScreenName();
		String dressAdv = question.getSubstring(INDEX_DRESS_ADV);
		String dress = question.getSubstring(INDEX_DRESS);
    	
    	if (tweet.contains("-10pv"))
    	{
    		String nomPoke = question.getSubstring(0);
    	
    		EntityManager em = DAOFactoryJPA.getEntityManager();
    		
	        Pokemon poke = em.find(Pokemon.class, nomPoke);
	        

	        if (poke.getPvRestant() <= 0)
	        {	
	        	return "#KO /cc [J] @" + juge + " by @" + dressAdv + " to @" + dress + " #PokeBattle";
	        }
    	}
		return null;
	}
		
}
