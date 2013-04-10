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
import org.junit.Ignore;
import org.junit.Test;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonStatCellTest {

    PokemonInfosCell cell = new PokemonInfosCell();
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
    public void testStatLevel() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #stat #level ?");
        assertEquals("@maitre_peter #level=1 #PokeBattle", cell.ask(tweet));
    }

    @Ignore
    @Test
    public void testStatXp() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #stat #xp ?");
        assertEquals("@maitre_peter #XP=0 #PokeBattle", cell.ask(tweet));
    }
    
    @Ignore
    @Test
    public void testStatPv() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #stat #pv ?");
        assertEquals("@maitre_peter #PV=100/100", cell.ask(tweet));
    }

}