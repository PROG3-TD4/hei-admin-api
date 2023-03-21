package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.repository.CourseRepository;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

}
