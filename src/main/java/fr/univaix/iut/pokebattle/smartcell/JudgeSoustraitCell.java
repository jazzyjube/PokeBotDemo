package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeSoustraitCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
    	String dressAdv = question.getSubstring(4);
    	String tweet = question.getText();
    	
    	if(!(dressAdv.equals("/cc")) && tweet.contains("#attack"))
    	{
    		String nomPokeAdv = question.getSubstring(0);
    		String dress = question.getSubstring(5);
    		
    		EntityManager em = DAOFactoryJPA.getEntityManager();
           

            Pokemon poke = em.find(Pokemon.class, nomPokeAdv);
            poke.setPvRestant(poke.getPvRestant() - 10);
            em.close();
            
            return "@" + nomPokeAdv + " -10pv /cc @" + dressAdv + " by @" + dress + " #PokeBattle";
    	}
		
		return null;
	}

}
