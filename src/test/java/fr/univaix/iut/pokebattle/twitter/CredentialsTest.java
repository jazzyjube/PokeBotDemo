package fr.univaix.iut.pokebattle.twitter;

import static org.fest.assertions.Assertions.assertThat;

import java.io.InputStream;

import org.junit.Test;

import fr.univaix.iut.pokebattle.tuse.Credentials;

public class CredentialsTest {
    @Test
    public void testLoadCredentialsGivenAValidPropertiesFileShouldReturnAValidCredentials() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("./twitter4jtest.properties");
        Credentials credentials = Credentials.loadCredentials(inputStream);
        assertThat(credentials.getConsumerKey()).isEqualTo("*******");
        assertThat(credentials.getConsumerSecret()).isEqualTo("*******");
        assertThat(credentials.getToken()).isEqualTo("*******");
        assertThat(credentials.getTokenSecret()).isEqualTo("*******");
    }
}
