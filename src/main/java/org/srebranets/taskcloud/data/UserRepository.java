package org.srebranets.taskcloud.data;

import org.springframework.data.repository.CrudRepository;
import org.srebranets.taskcloud.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
