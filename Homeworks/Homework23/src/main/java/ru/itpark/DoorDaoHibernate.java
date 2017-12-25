package ru.itpark;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class DoorDaoHibernate implements DoorDao{

    public EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

    public DoorDaoHibernate(SessionFactory factory){
        manager = factory.createEntityManager();
    }

    @Override
    public void create(Door door) {
        manager.getTransaction().begin();
        manager.persist(door);
        manager.getTransaction().commit();
    }


    @Override
    public Door find(Long id) {
        TypedQuery<Door> query = manager.createQuery("from Door door WHERE id=?",Door.class);
        query.setParameter(0,id);
        return query.getSingleResult();
    }

    @Override
    public void update(Door door) {
        manager.getTransaction().begin();
        manager.refresh(door);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Door door = manager.find(Door.class, id);
        if (door != null) {
            manager.getTransaction().begin();
            manager.remove(door);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void deleteByObject(Door door) {
        manager.getTransaction().begin();
        manager.remove(door);
        manager.getTransaction().commit();
    }


    @Override
    public List<Door> findAll() {
        //List<Door> list = new ArrayList<>();
        TypedQuery<Door> query = manager.createQuery("from Door door",Door.class);
        return query.getResultList();
    }


    @Override
    public List<Door> findAllByPrice(int price) {
        TypedQuery<Door> query = manager.createQuery("from Door door WHERE price=?",Door.class);
        query.setParameter(0,price);
        return query.getResultList();
    }

    @Override
    public Door findOneByModel(String model) {
        TypedQuery<Door> query = manager.createQuery("from Door door WHERE model=?",Door.class);
        query.setParameter(0,model);
        return query.getSingleResult();
    }
}