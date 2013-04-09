package fr.univaix.iut.pokebattle.run;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.Attaque;
import fr.univaix.iut.pokebattle.DataObjectAttack;
import fr.univaix.iut.pokebattle.DataObjectPokemon;
import fr.univaix.iut.pokebattle.PeutApprendre;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.Possede;

// Cette classe est censée être lancée qu'une seule fois pour charger les infos de pokedex.json

public class LoadDataPokedex {

	public static void main( String[] args ){
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(
                              new InputStreamReader(LoadDataPokedex.class.getClassLoader().getResourceAsStream("pokedex.json")));
        
        //Convertit le tableau json en objets Json
        DataObjectPokemon[] datagson = gson.fromJson(br, DataObjectPokemon[].class);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
        EntityManager em = emf.createEntityManager();
        
        for (DataObjectPokemon pkmn : datagson) {
        	
        	DataObjectAttack[] attaques = pkmn.getAttaques();
        	
        	// Recuperer les pokémons correspondants dans la bd
        	TypedQuery<Pokemon> q = em.createNamedQuery("findByPokeName", Pokemon.class);
        	q.setParameter ("pname", pkmn.getNom().toLowerCase());
        	List<Pokemon> results = q.getResultList();
        	
        	for(DataObjectAttack atk : attaques) {
    			// Objet Attaque
    			Attaque attaqueInsert = new Attaque();
    			// Objet du couple (Nom Pokémon, Attaque, Niveau apprentissage)
    			PeutApprendre obj = new PeutApprendre();
    			
        		// Si l'attaque n'existe pas déja dans la table ATTAQUE
        		if (em.find( Attaque.class, atk.getNom().toLowerCase()) == null ) {
        			//1
        			em.getTransaction().begin();
    				attaqueInsert.setNomA(atk.getNom().toLowerCase());
    				attaqueInsert.setPpMax(atk.getPp());	
    				em.persist(attaqueInsert);
    				em.getTransaction().commit();
        		}
        		
        		// Si le pokémon existe au moins une fois dans la base
        		if (results != null)
            	{
        			Iterator<Pokemon> it = results.iterator();
        			attaqueInsert = em.find(Attaque.class, atk.getNom().toLowerCase());
        			
        			while (it.hasNext())
        			{
        				Pokemon p = it.next();
        				
	            		em.getTransaction().begin();
	            		obj.setAttaque(attaqueInsert);
	            		int niveau = (atk.getNiveau().equals("Départ")) ?  0 : Integer.parseInt(atk.getNiveau().substring(2));
	            		obj.setLevel(niveau);
	            		obj.setPoke(p);
	            		em.persist(obj);
	            		// Si le pokemon peut l'apprendre, il possède alors la compétence
	            		if(niveau <= p.getLvl())
	            		{
	            			Possede poss = new Possede();
	            			poss.setAttaque(attaqueInsert);
	            			poss.setPokemon(p);
	            			poss.setPpRestant(attaqueInsert.getPpMax());
	            			em.persist(poss);
	            		}
	    				em.getTransaction().commit();
        			}
            	}
        		
        		
        	}
        	
        	
        }
        
        
	}
}