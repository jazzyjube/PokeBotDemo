package fr.univaix.iut.pokebattle.smartcell;


import java.util.List;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Combat;
import fr.univaix.iut.pokebattle.DAOCombat;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeFightOkCell implements SmartCell{

	static final int INDEX_NOMPOKE_2 = 4;
	@Override
	public String ask(Tweet question) throws TwitterException {
		
		String name = question.getScreenName();
    	String tweet = question.getText();

		
    	if(tweet.contains("#fight #ok"))
    	{
    		String nomPoke2 = question.getSubstring(INDEX_NOMPOKE_2);

    		DAOCombat dao = DAOFactoryJPA.createDAOCombat();
    		DAOPokemon daoP = DAOFactoryJPA.createDAOPokemon();
    		

    			List<Combat> combats = dao.findAll();
    			Combat lastCombat = combats.get(combats.size() - 1);
    			
    			lastCombat.setPoke2(nomPoke2);
    			dao.update(lastCombat);
    			
    			Pokemon poke1 = daoP.getById(lastCombat.getPoke1());
	    		String dress1 = poke1.getNomD();
	    		
	    		return "@" +  dress1 + " with @" + poke1.getNomP() + " vs @" + name 
	    				+ " with @" + nomPoke2 + " fight now" + " #PokeBattle";
	    	}
	    	
			return null;
	}

}

