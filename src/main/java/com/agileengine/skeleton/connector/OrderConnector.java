package com.agileengine.skeleton.connector;

import com.agileengine.skeleton.model.Order;
import com.agileengine.skeleton.model.Statistics;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderConnector {

    public Long insert();

    public void insertValues(List<Order> values);

    public List<Order> get();

    List<Order> getSorted(String columnName);

    List<Order> getWithOffsetAndLimit(int offset, int limit);

    List getSortedByPage(String columnName, int offset, int limit);

    List<Statistics> getOrderStatistics();
}