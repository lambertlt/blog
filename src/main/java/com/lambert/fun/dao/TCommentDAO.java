-e package com.lambert.fun.dao;

import com.lambert.fun.entity.TCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCommentDAO extends JpaRepository<TCommentEntity,Integer> {

}

