-e package com.lambert.fun.dao;

import com.lambert.fun.entity.TDiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TDiaryDAO extends JpaRepository<TDiaryEntity,Integer> {

}

