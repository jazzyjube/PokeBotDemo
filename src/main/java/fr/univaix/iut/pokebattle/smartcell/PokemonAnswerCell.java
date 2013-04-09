package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerCell implements SmartCell{
    public String ask(Tweet question) {
    	
    	String tweet = question.getText();
    	String name = question.getScreenName();
    	
    	
    	if (tweet.contains("Salut"))
    	{
    		
    		String str[] = tweet.split(" ");
    		String nompoke = str[0].substring(1);
    		
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();

            Pokemon poke = em.find(Pokemon.class, nompoke);
            
            em.close();
            emf.close();
    		return "@" + name + " " + poke.getCri() + " #PokeBattle";
    	}
    	return null ;
    	}
}