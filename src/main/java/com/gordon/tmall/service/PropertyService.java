package com.gordon.tmall.service;

import com.gordon.tmall.pojo.Property;

import java.util.List;

/**
 * @author gordon
 */
public interface PropertyService {
    void add(Property c);
    void delete(int id);
    void update(Property c);
    Property get(int id);
    List list(int cid);
}