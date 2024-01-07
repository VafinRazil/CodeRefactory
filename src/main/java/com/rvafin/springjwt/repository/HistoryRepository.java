package com.rvafin.springjwt.repository;

import com.rvafin.springjwt.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("select hy from History hy where hy.requestCreator.id = :userId")
    public List<History> getHistoriesByUser(@Param("userId") Long userId);
}
