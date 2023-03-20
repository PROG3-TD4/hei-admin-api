package school.hei.haapi.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.hei.haapi.endpoint.event.model.gen.UserUpserted;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.CourseStatus;
import school.hei.haapi.endpoint.rest.model.UpdateStudentCourse;
import school.hei.haapi.endpoint.rest.security.cognito.CognitoComponent;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.CourseFollowed;
import school.hei.haapi.repository.CourseFollowedRepository;
import school.hei.haapi.repository.CourseRepository;
import software.amazon.awssdk.services.cognitoidentityprovider.model.UsernameExistsException;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

  private final CourseRepository courseRepository;
  private final CourseFollowedRepository courseFollowedRep;

  private final CourseMapper courseMapper;

  public List<Course> getAllCourses(){
    return courseRepository.findAll();
  }

  public List<Course> crupdateCourse(List<Course> toCrupdate){
    return courseRepository.saveAll(toCrupdate);
  }

  public List<CourseFollowed> getAllCoursesFollowedByStudent(String studentId, CourseStatus status){
    return courseFollowedRep.findAllByStudentIdAndStatus(studentId, status);
  }

//  public List<CourseFollowed> updateCourseFollowedByStudent(String studentId,
//                                                            List<UpdateStudentCourse> toUpdate){
//  }

}
