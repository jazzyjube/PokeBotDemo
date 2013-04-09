package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonEndOfHealCell implements SmartCell {
	
	static final int INDEXNAME = 3;
	
    public String ask(Tweet question) {
    	
    	String tweet = question.getText();
    	
    	if (tweet.contains("DringDring") && tweet.contains("Jazz"))
    	{	
    		
    			String name = question.getSubstring(INDEXNAME); 

        		
        		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
                EntityManager em = emf.createEntityManager();
        	
                Pokemon poke = em.find(Pokemon.class, name);
                String dresseur = poke.getNomD();
                
                
                em.getTransaction().begin();
                
                poke.setPvRestant(poke.getPvMax());
                
                em.persist(poke);
                
                em.getTransaction().commit();
                em.close();
                emf.close();
                
                return "@" + dresseur + " @"+ name +" is restored to full health" + " #PokeBattle";
    	}
 	
    	return null ;
    	}
}
