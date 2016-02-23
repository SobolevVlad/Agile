package com.agileengine.skeleton.connector.impl;

import com.agileengine.skeleton.connector.OrderConnector;
import com.agileengine.skeleton.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderConnector")
public class OrderConnectorImpl implements OrderConnector {

    @Autowired
    private SessionFactory sessionFactory;

    public void insertValues(List<Order> values) {
        values.forEach(value -> sessionFactory.getCurrentSession().save(value));
    }

    public List<Order> get() {
        return  sessionFactory.getCurrentSession().createSQLQuery("Select * from ORDERS").list();
    }

    public List<Order> getSorted(String columnName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Order.class);
        criteria.addOrder(org.hibernate.criterion.Order.desc(columnName));
        return criteria.list();
    }

    @Override
    public List<Order> getWithOffsetAndLimit(int offset, int limit) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Order.class);
        criteria.setFirstResult(offset);
        criteria.setMaxResults(limit);
        return criteria.list();
    }

    @Override
    public List<Order> getSortedByPage(String columnName, int offset, int limit) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Order.class);
        criteria.setFirstResult(offset);
        criteria.setMaxResults(limit);
        criteria.addOrder(org.hibernate.criterion.Order.desc(columnName));
        return criteria.list();
    }

    public List getOrderStatistics() {
        String query = "Select customerCountry, sum(payment) from ORDERS WHERE CAST(orderTime as DATE) > '2015-07-01' GROUP by customerCountry";
        List list = sessionFactory.getCurrentSession().createSQLQuery(query).list();
        return list;
    }
}