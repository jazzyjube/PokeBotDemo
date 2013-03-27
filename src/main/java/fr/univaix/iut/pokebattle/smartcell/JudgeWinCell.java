package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeWinCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String NomPokeKO = question.getScreenName();
    	String Tweet = question.getText();
    	
    	if(Tweet.contains("#KO"))
    	{
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	
	        Combat combatCourant = em.find(Combat.class, NomPokeKO);
	        
	        em.getTransaction().begin();
			
			em.persist(poke);
			em.getTransaction().commit();
	        
	        em.close();
	        emf.close();
            return ;
    	}
		
		return null;
	}

}
