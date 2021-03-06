package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonInfosCell implements SmartCell {
	
    public String ask(Tweet question) {
    	
    	String tweet = question.getText();
    	String name = question.getScreenName();
    
    	
    	
    	if (tweet.contains("stat"))
    	{	
    		String str[] = tweet.split(" ");
    		String nompoke = str[0].substring(1);
    		
    		EntityManager em = DAOFactoryJPA.getEntityManager();

            Pokemon poke = em.find(Pokemon.class, nompoke);
            
            if(tweet.contains("level")){
            	
            	int level = poke.getLvl();
            	return "@"+ name + " #level=" + level + " #PokeBattle";
            	
            }
            
            if(tweet.contains("xp")){
            	
            	int xp = poke.getXp();
            	return "@"+ name + " #XP=" + xp + " #PokeBattle";
            	
            }
            
            if(tweet.contains("pv")){
            	
            	int pvRestant = poke.getPvRestant();
            	int pvMax = poke.getPvMax();
            	return "@"+ name + " #PV=" + pvRestant + "/" +pvMax + " #PokeBattle";
            	
            }

            em.close();
          
    	}
    	return null ;
    	}
}