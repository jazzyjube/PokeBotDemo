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
		
		String nomPokeKO = question.getScreenName();
    	String tweet = question.getText();
    	final int EXP_BASE = 200;
    	
    	
    	if(tweet.contains("#KO"))
    	{
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	
	        DAOCombat dao = new DAOCombatJpa(em);
	        
	        
	        List<Combat> combats = dao.findByPoke(em.find(Pokemon.class, nomPokeKO));
	        Combat combatCourant = combats.get(combats.size() - 1);
	        
	        combatCourant.setLoser(nomPokeKO);
	        
	        Pokemon pokeWin = dao.findWinner(combatCourant.getNumCombat());
	        combatCourant.setWinner(pokeWin.getNomP());
	        
			dao.update(combatCourant);

	        Pokemon poke = em.find(Pokemon.class, pokeWin.getNomP());
	        
	        int level = poke.getLvl();
	        
	        int exp = EXP_BASE * level / 7;
	        
	        
	        exp = poke.getXp() + exp;
	        
	        em.getTransaction().begin();
	        
	        poke.setXp(exp);
	        
	        em.persist(poke);
            
            em.getTransaction().commit();
	        
	        em.close();
	        emf.close();

	        return "@" + pokeWin.getNomP() + " #Win +"+exp+"xp" + " #PokeBattle";
    	}
		
		return null;
	}

}
