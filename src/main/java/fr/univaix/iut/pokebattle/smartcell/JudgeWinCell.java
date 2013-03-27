package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeWinCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		//String Name = question.getScreenName();
    	String Tweet = question.getText();
    	
    	if()
    	{
    		String NomPokeAdv = question.getSubstring(0);
    		String Dress = question.getSubstring(5);
    		
            return ;
    	}
		
		return null;
	}

}
