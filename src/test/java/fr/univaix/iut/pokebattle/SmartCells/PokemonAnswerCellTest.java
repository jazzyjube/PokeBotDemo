package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAnswerCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonAnswerCellTest {

    PokemonAnswerCell cell = new PokemonAnswerCell();

    @Test
    public void testSalutAnswer() {
    	Tweet tweet = new Tweet("maitre_peter", "Salut Salamèche !");
        assertEquals("@maitre_peter Sala Sala, Salamèèèèèèche", cell.ask(tweet));
    }

    @Test
    public void testNotSalutAnswer() {
        assertEquals(null, cell.ask(new Tweet("au revoir")));
    }

}