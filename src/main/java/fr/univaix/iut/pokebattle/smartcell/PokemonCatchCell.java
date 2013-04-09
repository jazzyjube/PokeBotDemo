package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCatchCell implements SmartCell {
    public String ask(Tweet question) throws TwitterException {
    	
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();
    	String NomPoke = question.getSubstring(0);
    	
    	if (Tweet.contains("Pokeball"))
    	{
    		
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();
            
            Pokemon poke = em.find(Pokemon.class, NomPoke);
            
            
            
    		
    			if (poke.getNomD() == null)
    			{
    				em.getTransaction().begin();
    				poke.setNomD(Name);
    				em.persist(poke);
    				em.getTransaction().commit();
    				
    				em.close();
    	            emf.close();
    	            TwitterFactory.getSingleton().updateProfile(null, null, poke.getLocalisation(), 
    	            		"#pokebattle - #pokemon - Owner : @" + Name + " - Level: " + poke.getLvl());
    				return "@" + Name + " @" + Name + " is my new owner !!!" + " #PokeBattle";
    			}
    				
    			else
    			{
    				em.close();
    	            emf.close();
    	            return "@" + Name + " @" + poke.getNomD() + " is my owner" + " #PokeBattle";
    			}
    				
    		
    	}
    	
    	return null ;
    	}
}
