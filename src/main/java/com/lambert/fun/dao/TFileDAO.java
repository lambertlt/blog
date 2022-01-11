-e package com.lambert.fun.dao;

import com.lambert.fun.entity.TFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TFileDAO extends JpaRepository<TFileEntity,Integer> {

}

