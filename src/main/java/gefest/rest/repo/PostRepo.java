package gefest.rest.repo;

import gefest.rest.domain.MyPost;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<MyPost, Long> {
}
