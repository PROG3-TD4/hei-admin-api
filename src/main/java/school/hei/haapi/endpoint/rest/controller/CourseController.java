package school.hei.haapi.endpoint.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.endpoint.rest.model.CourseStatus;
import school.hei.haapi.endpoint.rest.model.CrupdateCourse;
import school.hei.haapi.endpoint.rest.model.UpdateStudentCourse;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.service.CourseService;

@RestController
@AllArgsConstructor
public class CourseController {
  private CourseService courseService;
  private CourseMapper mapper;

  @GetMapping("/courses")
  private List<Course> getCourses(
      @RequestParam PageFromOne page,
      @RequestParam("page_size") BoundedPageSize pageSize
  ) {
    return courseService.getAllCourses().stream().map(
        course -> mapper.toRestCourse(course)
    ).collect(Collectors.toUnmodifiableList());
  }

  @PutMapping("/courses")
  public List<Course> crupdateCourse(
      @RequestBody List<CrupdateCourse> toCrupdate) {
    return courseService.crupdateCourse(toCrupdate.stream().map(
            rest -> mapper.toDomain(rest)).collect(Collectors.toUnmodifiableList())).stream()
        .map(
            domain -> mapper.toRestCourse(domain)
        ).collect(Collectors.toUnmodifiableList());
  }

  @GetMapping("/students/{student_id}/courses")
  public List<Course> getCourseFollowedByStudent(
      @RequestParam(required = true, name = "student_id") String studentId,
      @RequestParam(defaultValue = "LINKED", name = "status") CourseStatus status
  ){
    return courseService.getAllCoursesFollowedByStudent(studentId, status).stream()
        .map(courseFollowed -> mapper.toRest(courseFollowed)).collect(Collectors.toUnmodifiableList());
  }

  @PutMapping("/students/{student_id}/courses")
  public List<Course> updateCourseFollowed(
      @RequestParam(required = true, name = "student_id") String studentId,
      @RequestBody List<UpdateStudentCourse> toUpdate
  ){
    return null;
  }
}
