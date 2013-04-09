package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell {
	
    public String ask(Tweet question) {
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();
    	
    	
    	
    	
    	if (Tweet.contains("Owner"))
    	{
    		String str[] = Tweet.split(" ");
    		String nompoke = str[0].substring(1);
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();

            Pokemon poke = em.find(Pokemon.class, nompoke);
            
            em.close();
            emf.close();
            if (poke.getNomD() == null)
            {
            	return "@" + Name + " No owner"  + " #PokeBattle";
            }
    		return "@" + Name + " @" + poke.getNomD() + " is my owner" + " #PokeBattle";
    	}
    	return null ;
    	}
}
