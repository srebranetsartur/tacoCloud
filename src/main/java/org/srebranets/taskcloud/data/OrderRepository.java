package org.srebranets.taskcloud.data;

import org.springframework.data.repository.CrudRepository;
import org.srebranets.taskcloud.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
