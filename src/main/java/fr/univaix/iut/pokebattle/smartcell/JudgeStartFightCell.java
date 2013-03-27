package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeStartFightCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws TwitterException {
		
		//String Name = question.getScreenName();
    	String Tweet = question.getText();
    	
    	if(Tweet.contains("#fight") && !(Tweet.contains("#ok")))
    	{
    		String NomPokeAdv = question.getSubstring(0);
    		String Dress = question.getSubstring(5);
    		
            
    	}
    	
		return null;
	}

}
