package com.kbit.senicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kbit.senicare.entity.CareRecordEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CareRecordRepository extends JpaRepository<CareRecordEntity, Integer> {

    List<CareRecordEntity> findByCustomerNumberOrderByRecordNumberDesc(Integer customerNumber);

    @Transactional
    void deleteByCustomerNumber(Integer customerNumber);

}