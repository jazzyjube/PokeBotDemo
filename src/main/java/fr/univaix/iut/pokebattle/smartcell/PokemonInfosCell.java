package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonInfosCell implements SmartCell {
	
    public String ask(Tweet question) {
    	
    	String Tweet = question.getText();
    	String name = question.getScreenName();
    
    	
    	
    	if (Tweet.contains("stat"))
    	{	
    		String str[] = Tweet.split(" ");
    		String nompoke = str[0].substring(1);
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();

            Pokemon poke = em.find(Pokemon.class, nompoke);
            
            if(Tweet.contains("level")){
            	
            	int level = poke.getLvl();
            	return "@"+ name + " #level=" + level + " #PokeBattle";
            	
            }
            
            if(Tweet.contains("xp")){
            	
            	int XP = poke.getXp();
            	return "@"+ name + " #XP=" + XP + " #PokeBattle";
            	
            }
            
            if(Tweet.contains("pv")){
            	
            	int PVrestant = poke.getPvRestant();
            	int PVmax = poke.getPvMax();
            	return "@"+ name + " #PV=" + PVrestant + "/" +PVmax + " #PokeBattle";
            	
            }

            em.close();
            emf.close();
          
    	}
    	return null ;
    	}
}