package school.hei.haapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.CourseFollowed;


@Repository
public interface CourseFollowedRepository extends JpaRepository<CourseFollowed, String> {
}
