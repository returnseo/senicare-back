package com.kbit.senicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kbit.senicare.entity.TelAuthNumberEntity;


@Repository
public interface TelAuthNumberRepository extends JpaRepository<TelAuthNumberEntity, String> {


    boolean existsByTelNumberAndAuthNumber(String telNubmer, String authNumber);

    
}
