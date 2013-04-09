package fr.univaix.iut.pokebattle.smartcell;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.DAOCombat;
import fr.univaix.iut.pokebattle.DAOCombatJpa;
import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.DAOPokemonJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeFightOkCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String Name = question.getScreenName();
    	String Tweet = question.getText();

		
    	if(Tweet.contains("#fight #ok"))
    	{

    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	        
    		String NomPoke2 = question.getSubstring(4);

    		DAOCombat dao = new DAOCombatJpa(em);
    		DAOPokemon daoP = new DAOPokemonJPA(em);
    		

    			List<Combat> combats = dao.findAll();
    			Combat lastCombat = combats.get(combats.size() - 1);
    			
    			lastCombat.setPoke2(NomPoke2);
    			dao.update(lastCombat);
    			
    			Pokemon poke1 = daoP.getById(lastCombat.getPoke1());
	    		String dress1 = poke1.getNomD();
	    		
	    		return "@" +  dress1 + " with @" + poke1.getNomP() + " vs @" + Name 
	    				+ " with @" + NomPoke2 + " fight now" + " #PokeBattle";
	    	}
	            
	    //}
	    	
			return null;
	}

}

