package com.stoliar.petproject.gadgetshop.dao.impl;


import com.stoliar.petproject.gadgetshop.dao.UserDao;
import com.stoliar.petproject.gadgetshop.entity.Item;
import com.stoliar.petproject.gadgetshop.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User persist(User user) {
        sessionFactory.getCurrentSession().persist(user);
        return user;
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().createNamedQuery("delete").setParameter("name", user.getName())
                .setParameter("surname", user.getSurname())
                .setParameter("password", user.getPassword()).setParameter("email", user.getEmail())
                .setParameter("phonenumber", user.getPhoneNumber())
                .executeUpdate();
    }

    @Override
    public User findUserByEmail(String email) {
        List<User> users = sessionFactory.getCurrentSession().createNamedQuery("findUserByEmail", User.class).setParameter("email", email)
                .list();
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return sessionFactory.getCurrentSession().createNamedQuery("findAllUsers", User.class).list();
    }

    @Override
    public User updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }

    @Override
    public Map<Item, Integer> findCartByUser(User user) {
        return user.getCart();
    }


}

