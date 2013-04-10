package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonHealCellTest {

    PokemonHealCell cell = new PokemonHealCell();
    PokemonEndOfHealCell cell1 = new PokemonEndOfHealCell();
    private static EntityManager em;
    private static FlatXmlDataSet dataset;
    private static DatabaseConnection dbUnitConnection;
    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void initTestFixture() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
        em = entityManagerFactory.createEntityManager();
        DAOFactoryJPA.setEntityManager(em);
        //... suite des initialisations pour les tests
        Connection connection = ((EntityManagerImpl) (em.getDelegate())).getServerSession().getAccessor().getConnection();

        dbUnitConnection = new DatabaseConnection(connection);
        //Loads the data set from a file
        dataset = new FlatXmlDataSetBuilder().build(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("pokemonDataset.xml"));
    }
    
    @AfterClass 
    public static void finishTestFixture() throws Exception { 
    	entityManagerFactory.close();

    }
    
    @Before
    public void setUp() throws Exception {
        //Clean the data from previous test and insert new data test.
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataset);
    }
    
    
    @Test
    public void testFirstHeal() {
    	Tweet tweet = new Tweet("maitre_peter", "@heal_joelle #heal @sala_meche");
        assertEquals("@sala_meche #stat #PV ? #PokeBattle", cell.ask(tweet));
    }
    
    @Test
    public void testSecondHeal() {
    	Tweet tweet = new Tweet("kai_minus", "@heal_joelle #PV=50/100");
        assertEquals("@kai_minus come in the #pokecenter / @PokeTimer #WakeMeUp 5 Min #Jazz #kai_minus #PokeBattle", cell.ask(tweet));
    }

    @Test
    public void testStatPv() {
    	Tweet tweet = new Tweet("PokeTimer", "@heal_joelle #DringDring #Jazz #sala_meche");
        assertEquals("@maitre_peter @sala_meche is restored to full health #PokeBattle", cell1.ask(tweet));
    }

}