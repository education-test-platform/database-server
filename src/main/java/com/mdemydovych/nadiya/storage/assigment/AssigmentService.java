package com.mdemydovych.nadiya.storage.assigment;


import com.mdemydovych.nadiya.model.request.AssignStudentRequest;
import com.mdemydovych.nadiya.model.user.UserDto;
import com.mdemydovych.nadiya.storage.assigment.domain.Assigment;
import com.mdemydovych.nadiya.storage.assigment.domain.Assigment.AssigmentId;
import com.mdemydovych.nadiya.storage.user.UserService;
import java.util.List;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssigmentService {

  private final AssigmentRepository assigmentRepository;

  private final UserService userService;

  public void assignStudentToTeacher(AssignStudentRequest request) {
    Assigment assigment = new Assigment();
    assigment.setId(new AssigmentId(request.teacherId(), request.studentId()));
    assigmentRepository.save(assigment);
  }

  public List<UserDto> findStudentTeachers(String studentId) {
    List<Assigment> assigment = assigmentRepository.findAllById_StudentId(studentId);
    return userService.findByIds(extractIds(assigment, AssigmentId::getTeacherId));
  }

  public List<UserDto> findTeacherStudents(String teacherId) {
    List<Assigment> assigment = assigmentRepository.findAllById_TeacherId(teacherId);
    return userService.findByIds(extractIds(assigment, AssigmentId::getStudentId));
  }

  private List<String> extractIds(List<Assigment> assigments,
      Function<AssigmentId, String> function) {
    return assigments.stream()
        .map(Assigment::getId)
        .map(function)
        .toList();
  }
}
