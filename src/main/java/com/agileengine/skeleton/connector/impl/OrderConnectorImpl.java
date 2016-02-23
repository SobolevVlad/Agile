package com.agileengine.skeleton.connector.impl;

import com.agileengine.skeleton.connector.OrderConnector;
import com.agileengine.skeleton.model.Order;
import com.agileengine.skeleton.model.Statistics;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component("orderConnector")
public class OrderConnectorImpl implements OrderConnector {

    @Autowired
    private SessionFactory sessionFactory;

    public Long insert() {
        return (Long) sessionFactory.getCurrentSession().save(createOrder());
    }

    public void insertValues(List<Order> values) {
        values.forEach(value -> sessionFactory.getCurrentSession().save(value));
    }

    private Order createOrder() {
        String s = "2015/06/01 01:19:27.006";
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.ENGLISH);
        Date parsedDate = null;
        try {
            parsedDate = df.parse(s);
        } catch (ParseException e) {
            //Not reachable because validated before
        }
        return new Order("8e57f829-9f68-49e5-a27b-6ce1e05f3cfb", "3-Piece Cardigan Set", parsedDate, 9,
                108, "684 Brown Bear Drive", "c861d498-c42c-4e99-a5e8-04b3da0f94fb", "Ronald", "Curtis",
                "United States", "684 Brown Bear Drive");
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

    public List<Statistics> getOrderStatistics() {
        String query = "Select customerCountry, sum(payment) from ORDERS HAVING TIME >=  '20150701'";
        List list = sessionFactory.getCurrentSession().createSQLQuery(query).list();
        return list;
    }
}