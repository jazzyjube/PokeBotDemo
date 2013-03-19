package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
        assertEquals("Sala Sala, Salamèèèèèèche", cell.ask(new Tweet("Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals(null, cell.ask(new Tweet("au revoir")));
    }

}