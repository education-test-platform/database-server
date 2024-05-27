package com.mdemydovych.nadiya.storage.controller;

import com.mdemydovych.nadiya.model.request.AssignStudentRequest;
import com.mdemydovych.nadiya.model.user.UserDto;
import com.mdemydovych.nadiya.storage.assigment.AssigmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assigment")
public class AssigmentController {

  private final AssigmentService assigmentService;

  @PostMapping("/assign/student/to/teacher")
  public void assignStudentToTeacher(@RequestBody AssignStudentRequest request) {
    assigmentService.assignStudentToTeacher(request);
  }

  @GetMapping("/find/student/teachers/{studentId}")
  public List<UserDto> getStudentTeachers(@PathVariable String studentId) {
    return assigmentService.findStudentTeachers(studentId);
  }

  @GetMapping("/find/teacher/students/{teacherId}")
  public List<UserDto> getTeacherStudents(@PathVariable String teacherId) {
    return assigmentService.findTeacherStudents(teacherId);
  }
}
