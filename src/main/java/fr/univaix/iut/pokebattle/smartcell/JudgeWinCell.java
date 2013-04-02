package fr.univaix.iut.pokebattle.smartcell;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.DAOCombat;
import fr.univaix.iut.pokebattle.DAOCombatJpa;
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
	
	        DAOCombat dao = new DAOCombatJpa(em);
	        		// passer une string au lieu d'un pokemon
	        List<Combat> combats = dao.findByPoke(em.find(Pokemon.class, NomPokeKO));
	        //combats.get(0).setLoser(NomPokeKO);
	        /*Combat combatCourant = em.find(Combat.class, NomPokeKO);
	        
	        em.getTransaction().begin();
			
			em.persist(poke);
			em.getTransaction().commit();*/
	        Pokemon pokeWin = dao.findWinner(combats.get(0).getNumCombat());
	        
	        em.close();
	        emf.close();
	        
	        return pokeWin.getNomP();
            //return ;
    	}
		
		return null;
	}

}
