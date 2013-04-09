package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeStartFightCellTest {
	
	JudgeStartFightCell cell = new JudgeStartFightCell();
	
	@Test
    public void testStartFightCellTest() throws TwitterException {
    	Tweet tweet = new Tweet("maitre_peter", "@topdresseur_red #fight with @dialga_shiny /cc @juge_otte");
        assertEquals("@maitre_peter @dialga_shiny registered #PokeBattle", cell.ask(tweet)); 
    }

}
