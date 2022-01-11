-e package com.lambert.fun.dao;

import com.lambert.fun.entity.TCommentReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCommentReplyDAO extends JpaRepository<TCommentReplyEntity,Integer> {

}

