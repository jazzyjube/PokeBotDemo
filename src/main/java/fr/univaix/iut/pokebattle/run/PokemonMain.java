package fr.univaix.iut.pokebattle.run;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {
	
	
	private static Map<String, String> createConfigurationMap() throws URISyntaxException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));
	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

	    Map<String, String> props = new HashMap<String, String>();
	    props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
	    props.put("eclipselink.target-database", "PostgreSQL");
	    props.put("javax.persistence.jdbc.url", dbUrl);
	    props.put("javax.persistence.jdbc.user", username);
	    props.put("javax.persistence.jdbc.password", password);
	    return props;
	}
	
    public static void main(String[] args) throws URISyntaxException {
    	
    	Map<String, String> props = createConfigurationMap();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU", props);
        EntityManager em = emf.createEntityManager();

        DAOFactoryJPA.setEntityManager(em);
    	
    	BotRunner.runBot(new PokeBot(), "twitter4jKai.properties");
        
        
    }
}
