-e package com.lambert.fun.dao;

import com.lambert.fun.entity.TPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPostDAO extends JpaRepository<TPostEntity,Integer> {

}

