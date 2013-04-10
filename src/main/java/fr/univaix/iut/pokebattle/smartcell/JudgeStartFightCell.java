package fr.univaix.iut.pokebattle.smartcell;

import java.util.List;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.DAOCombat;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeStartFightCell implements SmartCell{

	static final int INDEX_NOMPOKE_1 = 3;
	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String name = question.getScreenName();
    	String tweet = question.getText();
    	
    	if(tweet.contains("#fight") && !(tweet.contains("#ok")))
    	{
    		DAOCombat dao = DAOFactoryJPA.createDAOCombat();
    		DAOPokemon daoP = DAOFactoryJPA.createDAOPokemon();
    	
    		String nomPoke1 = question.getSubstring(INDEX_NOMPOKE_1);
    		
    		
    		if (daoP.getById(nomPoke1).getNomD().equals(name))
    		{
    			List<Combat> combats = dao.findAll();
    			Combat lastComb = combats.get(combats.size() - 1);
    			
	    		Combat comb = new Combat((lastComb.getNumCombat() + 1), nomPoke1, null, null, null);
	    		dao.insert(comb);
	    		
	    		return "@" + name + " @" + nomPoke1 + " registered" + " #PokeBattle";
    		}
            
    	}
    	
		return null;
	}

}
