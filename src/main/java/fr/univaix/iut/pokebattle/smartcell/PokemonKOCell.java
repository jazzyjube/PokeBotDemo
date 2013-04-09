package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String Tweet = question.getText();
		String Juge = question.getScreenName();
		String DressAdv = question.getSubstring(5);
		String Dress = question.getSubstring(3);
    	
    	if (Tweet.contains("-10pv"))
    	{
    		String NomPoke = question.getSubstring(0);
    		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	
	        Pokemon poke = em.find(Pokemon.class, NomPoke);
	        
	        em.close();
	        emf.close();
		
	        if (poke.getPvRestant() <= 0)
	        	return "#KO /cc [J] @" + Juge + " by @" + DressAdv + " to @" + Dress + " #PokeBattle";
	         
    	}
		return null;
	}
	
	

}
