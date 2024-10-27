package com.ispydeer.DutyManager.repositories;

import com.ispydeer.DutyManager.duty.Duty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DutyRepository extends JpaRepository<Duty, Integer> {

    @Query("SELECT r FROM Duty r WHERE r.assigner = ?1 OR r.supervisor = ?1 OR r.executor = ?1 ORDER BY r.isDone, r.priority DESC, r.targetDate")
    List<Duty> findDuties(String username);
}
