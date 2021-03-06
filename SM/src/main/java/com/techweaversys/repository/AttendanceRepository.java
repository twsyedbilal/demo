package com.techweaversys.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.Attendance;


@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>, JpaSpecificationExecutor<Attendance> {

	List<Attendance> findAllByClasssId(Long id);

	List<Attendance> findAllByAdmissionId(Long id);

	List<Attendance> findAllBydate(Calendar date);

}
