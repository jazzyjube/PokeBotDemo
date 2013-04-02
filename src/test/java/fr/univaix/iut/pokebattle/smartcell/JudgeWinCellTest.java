package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeWinCellTest {

	JudgeWinCell cell = new JudgeWinCell();
	
	@Test
    public void testWinCellTest() throws TwitterException {
    	Tweet tweet = new Tweet("sala_meche", "#KO /cc [J] @juge_otte by @topdresseur_red to @maitre_peter");
        assertEquals("kai_minus", cell.ask(tweet)); 
    }
	
}
