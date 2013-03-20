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
            
            em.close();
            emf.close();
            
            
    		if (poke.getNomP().equals(NomPoke))
    		{
    			if (poke.getNomD() == null)
    				return "@" + Name + "no owner.";
    			else
    				return "@" + Name + " @" + poke.getNomD() + " is my owner";
    		}
    	}
    	
    	return null ;
    	}
}
