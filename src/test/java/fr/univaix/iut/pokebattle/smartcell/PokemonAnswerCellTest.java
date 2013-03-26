package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAnswerCellTest {

    PokemonAnswerCell cell = new PokemonAnswerCell();

    @Test
    public void testSalutAnswer() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche Salut Salamèche !");
        assertEquals("@maitre_peter Sala Sala Salameeeeche", cell.ask(tweet));
    }

    @Test
    public void testNotSalutAnswer() {
        assertEquals(null, cell.ask(new Tweet("au revoir")));
    }

}