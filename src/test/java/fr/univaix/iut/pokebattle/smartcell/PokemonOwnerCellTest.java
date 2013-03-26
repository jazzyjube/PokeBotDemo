package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCellTest {
	PokemonOwnerCell cell = new PokemonOwnerCell();

    @Test
    public void testSalutOwner() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche Owner ?");
        assertEquals("@maitre_peter @maitre_peter is my owner", cell.ask(tweet));
    }

    @Test
    public void testOwnerAnswerNo() throws TwitterException {
    	Tweet tweet = new Tweet("maitre_peter", "@mew_sauvage Owner ?");
        assertEquals("@maitre_peter No owner", cell.ask(tweet));
    }
    

}