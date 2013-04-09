package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCellTest {

	PokemonKOCell cell = new PokemonKOCell();
	
    @Test
    public void testKOAnswer() throws TwitterException {
    	Tweet tweet = new Tweet("juge_otte", "@sala_meche -10pv /cc @maitre_peter by @topdresseur_red");
        assertEquals("#KO /cc [J] @juge_otte by @topdresseur_red to @maitre_peter #PokeBattle", cell.ask(tweet));
    }
}
