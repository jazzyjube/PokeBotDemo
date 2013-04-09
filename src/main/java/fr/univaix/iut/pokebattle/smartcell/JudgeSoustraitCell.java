package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeSoustraitCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
    	//String Name = question.getScreenName();
    	String DressAdv = question.getSubstring(4);
    	String Tweet = question.getText();
    	
    	if(!(DressAdv.equals("/cc")) && Tweet.contains("#attack"))
    	{
    		String NomPokeAdv = question.getSubstring(0);
    		String Dress = question.getSubstring(5);
    		
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();

            Pokemon poke = em.find(Pokemon.class, NomPokeAdv);
            poke.setPvRestant(poke.getPvRestant() - 10);
            em.close();
            emf.close();
            
            return "@" + NomPokeAdv + " -10pv /cc @" + DressAdv + " by @" + Dress + " #PokeBattle";
    	}
		
		return null;
	}

}
