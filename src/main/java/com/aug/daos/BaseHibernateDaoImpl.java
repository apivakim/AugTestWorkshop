package com.aug.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseHibernateDaoImpl<T extends Serializable> implements BaseHibernateDao<T> {
    private Class<T> clazz;
    
    @Autowired
    SessionFactory sessionFactory;
    
    protected BaseHibernateDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T getById(final Integer id) {
        if(id != null)
            return (T) getCurrentSession().get(clazz, id);
        else
            return null;
    }

    public List<T> findAll() {
        return getCurrentSession().createCriteria(clazz).list();
    }

    @Transactional(readOnly = false)
    public void save(final T entity) {
        getCurrentSession().persist(entity);
    }

    @Transactional(readOnly = false)
    public void update(final T entity) {
        getCurrentSession().merge(entity);
    }

    @Transactional(readOnly = false)
    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}