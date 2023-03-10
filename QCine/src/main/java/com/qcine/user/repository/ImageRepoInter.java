package com.qcine.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qcine.model.entity.Image;

@Repository
public interface ImageRepoInter extends JpaRepository<Image, Integer>
{

}
