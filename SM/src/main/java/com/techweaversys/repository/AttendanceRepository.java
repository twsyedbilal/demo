package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>, JpaSpecificationExecutor<Attendance> {

}
