package org.srebranets.taskcloud.data;

import org.springframework.data.repository.CrudRepository;
import org.srebranets.taskcloud.domain.Taco;


public interface TacoRepository extends CrudRepository<Taco, Long> {

}
