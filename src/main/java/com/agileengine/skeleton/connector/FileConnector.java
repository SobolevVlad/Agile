package com.agileengine.skeleton.connector;

import com.agileengine.skeleton.dto.OrderDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileConnector {

    List<OrderDto> loadData(String path);
}
