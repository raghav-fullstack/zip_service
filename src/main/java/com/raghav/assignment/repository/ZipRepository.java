package com.raghav.assignment.repository;

import com.raghav.assignment.entity.ZipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ZipRepository extends JpaRepository<ZipEntity, Long> {

    @Query(value = "SELECT * FROM ZIPCODES WHERE ZIP_CODE = :zipcode", nativeQuery = true)
    ZipEntity findByZip(@Param("zipcode") int zipCode);

    @Query(value = "SELECT * FROM ZIPCODES WHERE STATE_CODE = :statecode", nativeQuery = true)
    List<ZipEntity> findZipCountyDetailsZipStateCode(@Param("statecode") String stateCode);

}
