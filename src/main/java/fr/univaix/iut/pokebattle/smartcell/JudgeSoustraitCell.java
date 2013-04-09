package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeSoustraitCell implements SmartCell{
	
	static final int INDEXDRESSADV = 4;
	static final int INDEXDRESS = 5;
	static final int PVPERDUS = 10;
	@Override
	public String ask(Tweet question) throws TwitterException {
		
    	String dressAdv = question.getSubstring(INDEXDRESSADV);
    	String tweet = question.getText();
    	
    	if(!(dressAdv.equals("/cc")) && tweet.contains("#attack"))
    	{
    		String nomPokeAdv = question.getSubstring(0);
    		String dress = question.getSubstring(INDEXDRESS);
    		
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();

            Pokemon poke = em.find(Pokemon.class, nomPokeAdv);
            poke.setPvRestant(poke.getPvRestant() - PVPERDUS);
            em.close();
            emf.close();
            
            return "@" + nomPokeAdv + " -10pv /cc @" + dressAdv + " by @" + dress + " #PokeBattle";
    	}
		
		return null;
	}

}
