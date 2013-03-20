package fr.univaix.iut.pokebattle.smartcells;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonCatchCell implements SmartCell {
    public String ask(Tweet question) {
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();
    	String NomPoke = question.getSubstring(0);
    	
    	if (Tweet.contains("Pokeball"))
    	{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();
            
            System.out.println(NomPoke);
            
            Pokemon poke = em.find(Pokemon.class, NomPoke);
            
            
            
    		
    			if (poke.getNomD() == null)
    			{
    				em.getTransaction().begin();
    				poke.setNomD(Name);
    				em.persist(poke);
    				em.getTransaction().commit();
    				
    				em.close();
    	            emf.close();
    				return "@" + Name + " @" + Name + " is my new owner !!!";
    			}
    				
    			else
    			{
    				em.close();
    	            emf.close();
    	            return "@" + Name + " @" + poke.getNomD() + " is my owner";
    			}
    				
    		
    	}
    	
    	return null ;
    	}
}
