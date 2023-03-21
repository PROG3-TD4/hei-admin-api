package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.repository.CourseRepository;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public Course createOrUpdateCourse(Course newCourse){
        Course existingCourse = courseRepository.findById(courseId).orElse(null);
        if (existingCourse != null) {
            existingCourse.setCode(course.getCode());
            existingCourse.setName(course.getName());
            existingCourse.setCredits(course.getCredits());
            existingCourse.setTotalHours(course.getTotalHours());
            existingCourse.setTeacher(course.getTeacher());
            Course updatedCourse = courseRepository.saveAll(existingCourse);
        } else {
            course.setCourseId(courseId);
            Course createdCourse = courseRepository.saveAll(course);
        }
    }

}
