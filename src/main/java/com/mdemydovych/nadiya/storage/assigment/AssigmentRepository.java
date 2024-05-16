package com.mdemydovych.nadiya.storage.assigment;

import com.mdemydovych.nadiya.storage.assigment.domain.Assigment;
import com.mdemydovych.nadiya.storage.assigment.domain.Assigment.AssigmentId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface AssigmentRepository extends JpaRepository<Assigment, AssigmentId> {

  List<Assigment> findAllById_StudentId(String studentId);

  List<Assigment> findAllById_TeacherId(String teacherId);
}
