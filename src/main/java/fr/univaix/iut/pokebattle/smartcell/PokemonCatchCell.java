package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCatchCell implements SmartCell {
    public String ask(Tweet question) throws TwitterException {
    	
    	
    	String tweet = question.getText();
    	String name = question.getScreenName();
    	String nomPoke = question.getSubstring(0);
    	
    	if (tweet.contains("Pokeball"))
    	{
    		
    		EntityManager em = DAOFactoryJPA.getEntityManager();
            
            Pokemon poke = em.find(Pokemon.class, nomPoke);
            
            
            
    		
    			if (poke.getNomD() == null)
    			{
    				em.getTransaction().begin();
    				poke.setNomD(name);
    				em.persist(poke);
    				em.getTransaction().commit();
    				
    				em.close();
    	           
    	            TwitterFactory.getSingleton().updateProfile(null, null, poke.getLocalisation(), 
    	            		"#pokebattle - #pokemon - Owner : @" + name + " - Level: " + poke.getLvl());
    				return "@" + name + " @" + name + " is my new owner !!!" + " #PokeBattle";
    			}
    				
    			else
    			{
    				em.close();
    	            return "@" + name + " @" + poke.getNomD() + " is my owner" + " #PokeBattle";
    			}
    				
    		
    	}
    	
    	return null ;
    	}
}
