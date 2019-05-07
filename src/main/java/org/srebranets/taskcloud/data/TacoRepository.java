package org.srebranets.taskcloud.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.srebranets.taskcloud.domain.Taco;


public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
