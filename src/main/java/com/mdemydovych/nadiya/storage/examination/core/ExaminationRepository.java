package com.mdemydovych.nadiya.storage.examination.core;

import com.mdemydovych.nadiya.storage.examination.core.domain.Examination;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, UUID> {

  List<Examination> findByTeacherId(String id);
}
