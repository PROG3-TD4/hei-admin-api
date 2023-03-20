package school.hei.haapi.endpoint.rest.mapper;

import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.endpoint.rest.model.CrupdateCourse;
import school.hei.haapi.endpoint.rest.model.UpdateStudentCourse;
import school.hei.haapi.model.CourseFollowed;
import school.hei.haapi.repository.CourseRepository;
import school.hei.haapi.repository.UserRepository;

@Component
public class CourseMapper {
  private UserMapper mapper;
  private UserRepository userRepository;

  private CourseRepository courseRepository;
  public Course toRestCourse(school.hei.haapi.model.Course domain) {
    return new Course()
        .id(domain.getCourseId())
        .code(domain.getCode())
        .credits(domain.getCredits())
        .name(domain.getName())
        .mainTeacher(mapper.toRestTeacher(domain.getTeacher()))
        .totalHours(domain.getTotalHours());
  }

  public school.hei.haapi.model.Course toDomainCourse(Course rest){
    return school.hei.haapi.model.Course.builder()
        .courseId(rest.getId())
        .code(rest.getCode())
        .credits(rest.getCredits())
        .name(rest.getName())
        .teacher(mapper.toDomain(rest.getMainTeacher()))
        .totalHours(rest.getTotalHours())
        .build();
  }

  public school.hei.haapi.model.Course toDomain(CrupdateCourse toCrupdate){
    return school.hei.haapi.model.Course.builder()
        .courseId(toCrupdate.getId())
        .code(toCrupdate.getCode())
        .credits(toCrupdate.getCredits())
        .name(toCrupdate.getName())
        .teacher(userRepository.getById(toCrupdate.getMainTeacherId()))
        .totalHours(toCrupdate.getTotalHours())
        .build();
  }

  public Course toRest(CourseFollowed domain){
    return new Course()
        .id(domain.getId())
        .code(domain.getCourse().getCode())
        .credits(domain.getCourse().getCredits())
        .name(domain.getCourse().getName())
        .mainTeacher(mapper
            .toRestTeacher(domain.getCourse().getTeacher()))
        .totalHours(domain.getCourse().getTotalHours());
  }

  public CourseFollowed toDomain(UpdateStudentCourse rest){
    return CourseFollowed.builder()
        .course(courseRepository.getById(rest.getCourseId()))
        .status(rest.getStatus())
        .build();
  }
}
