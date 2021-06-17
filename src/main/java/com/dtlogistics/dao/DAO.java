package com.dtlogistics.dao;

import java.util.List;

public interface DAO <Entity> {

    Entity findById (int id);

    List<Entity> findAll();

    void save(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);
}
