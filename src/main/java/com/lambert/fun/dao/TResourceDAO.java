-e package com.lambert.fun.dao;

import com.lambert.fun.entity.TResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TResourceDAO extends JpaRepository<TResourceEntity,Integer> {

}

