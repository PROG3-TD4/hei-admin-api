package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    // please add a mapper and if it doesn't work yet, replace ResponseEntity with List of courses.
    // Thank you Ilo.
    @PutMapping("/courses")
    public ResponseEntity<Course> saveAll(@RequestBody Course course) {
        Course updatedCourse = courseService.createOrUpdateCourse(course);
        return ResponseEntity.ok(updatedCourse);
    }
}
