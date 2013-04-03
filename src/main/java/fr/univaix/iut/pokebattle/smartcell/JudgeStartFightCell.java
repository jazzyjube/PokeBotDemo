package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.DAOCombat;
import fr.univaix.iut.pokebattle.DAOCombatJpa;
import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.DAOPokemonJPA;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeStartFightCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String Name = question.getScreenName();
    	String Tweet = question.getText();
    	
    	if(Tweet.contains("#fight") && !(Tweet.contains("#ok")))
    	{
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	        
    		String NomPoke1 = question.getSubstring(3);
    		
    		DAOCombat dao = new DAOCombatJpa(em);
    		DAOPokemon daoP = new DAOPokemonJPA(em);
    		
    		if (daoP.getById(NomPoke1).getNomD().equals(Name))
    		{
	    		Combat comb = new Combat(1, NomPoke1, null, null, null);
	    		dao.insert(comb);
    		}
            
    	}
    	
		return null;
	}

}
