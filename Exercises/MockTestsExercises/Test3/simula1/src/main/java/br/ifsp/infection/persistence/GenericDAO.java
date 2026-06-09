package br.ifsp.infection.persistence;

import java.util.List;

public interface GenericDAO <K,V>{
    void insert(V value);

    void update(V value);

    void delete(K key);

    boolean existsById(K key);

    List<V> findAll();
}