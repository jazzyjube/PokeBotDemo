package fr.univaix.iut.pokebattle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAOCombatJpa implements DAOCombat {
	
	private EntityManager entityManager;

	public DAOCombatJpa(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public boolean delete(Combat obj) {
		try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(obj);
            tx.commit();
            return true;
            
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public Combat getById(Integer id) {
		return entityManager.find(Combat.class, id);
	}

	@Override
	public Combat insert(Combat obj) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(obj);
        tx.commit();
        return entityManager.find(Combat.class, obj.getNumCombat());
	}

	@Override
	public boolean update(Combat obj) {
		try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public List<Combat> findByPoke(Pokemon poke) {
		TypedQuery<Combat> query = entityManager.createQuery(Combat.FIND_BY_POKE, Combat.class);
		query.setParameter("pokeko", poke);
		return query.getResultList();
	}

	@Override
	public List<Combat> findAll() {
		TypedQuery<Combat> query = entityManager.createNamedQuery(Combat.FIND_ALL, Combat.class);
        return query.getResultList();
	}
}


