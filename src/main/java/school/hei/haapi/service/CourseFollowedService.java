package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.repository.CourseFollowedRepository;

@Service
@AllArgsConstructor
public class CourseFollowedService {

    private final CourseFollowedRepository courseFollowedRepository;

}
