package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeFightOkCellTest {
	
	JudgeFightOkCell cell = new JudgeFightOkCell();
	
	 @Test
	    public void testOkFight() throws TwitterException {
	    	Tweet tweet = new Tweet("topdresseur_red", "@maitre_peter #fight #ok with @kai_minus /cc @juge_otte");
	        assertEquals("@maitre_peter with @dialga_shiny vs @topdresseur_red with @kai_minus fight now", cell.ask(tweet));
	    }

}
