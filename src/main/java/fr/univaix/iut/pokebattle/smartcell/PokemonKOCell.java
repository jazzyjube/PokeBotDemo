package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCell implements SmartCell{
	
	static final int INDEXDRESS = 3;
	static final int INDEXDRESSADV = 5;
	
	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String tweet = question.getText();
		String juge = question.getScreenName();
		String dressAdv = question.getSubstring(INDEXDRESSADV);
		String dress = question.getSubstring(INDEXDRESS);
    	
    	if (tweet.contains("-10pv"))
    	{
    		String nomPoke = question.getSubstring(0);
    		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	
	        Pokemon poke = em.find(Pokemon.class, nomPoke);
	        
	        em.close();
	        emf.close();
		
	        if (poke.getPvRestant() <= 0)
	        {	
	        	return "#KO /cc [J] @" + juge + " by @" + dressAdv + " to @" + dress + " #PokeBattle";
	        }
    	}
		return null;
	}
		
}
