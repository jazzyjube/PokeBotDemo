package fr.univaix.iut.pokebattle.smartcell;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.DAOCombat;
import fr.univaix.iut.pokebattle.DAOCombatJpa;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeWinCell implements SmartCell{
	
	static final int EXPDIV = 7;
	
	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String nomPokeKO = question.getScreenName();
    	String tweet = question.getText();
    	final int expbase = 200;
    	
    	
    	if(tweet.contains("#KO"))
    	{
	
	        DAOCombat dao = DAOFactoryJPA.createDAOCombat();
	        
	        EntityManager em = DAOFactoryJPA.getEntityManager();
	        
	        List<Combat> combats = dao.findByPoke(em.find(Pokemon.class, nomPokeKO));
	        Combat combatCourant = combats.get(combats.size() - 1);
	        
	        combatCourant.setLoser(nomPokeKO);
	        
	        Pokemon pokeWin = dao.findWinner(combatCourant.getNumCombat());
	        combatCourant.setWinner(pokeWin.getNomP());
	        
			dao.update(combatCourant);

	        Pokemon poke = em.find(Pokemon.class, pokeWin.getNomP());
	        
	        int level = poke.getLvl();
	        
<<<<<<< HEAD
	        int exp = expbase * level / EXPDIV;
=======
	        int exp = expbase * level / 7;
>>>>>>> master
	        
	        
	        exp = poke.getXp() + exp;
	        
	        em.getTransaction().begin();
	        
	        poke.setXp(exp);
	        
	        em.persist(poke);
            
            em.getTransaction().commit();
	        
	        em.close();

	        return "@" + pokeWin.getNomP() + " #Win +"+exp+"xp" + " #PokeBattle";
    	}
		
		return null;
	}

}
