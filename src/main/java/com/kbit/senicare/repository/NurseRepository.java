package com.kbit.senicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kbit.senicare.entity.NurseEntity;


@Repository
public interface NurseRepository extends JpaRepository<NurseEntity, String> {

    boolean existsByUserId(String userId);
    boolean existsByTelNumber(String telNumber);

    NurseEntity findByUserId(String userId);
    NurseEntity findBySnsIdAndJoinPath(String sns, String joinPath);
    
}
