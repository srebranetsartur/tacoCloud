package org.srebranets.taskcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.srebranets.taskcloud.data.OrderRepository;
import org.srebranets.taskcloud.domain.Order;

import java.util.Optional;

@RestController("orderRestController")
@RequestMapping("/order")
public class OrderController {
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PutMapping("/{orderId}")
    public Order putOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order updateOrder(@PathVariable("orderId") Long orderId,
                                      @RequestBody Order order) {
        Order oldOrder = orderRepository.findById(orderId).get();

        //ToDo Write a logic that equals same field and if they aren't equals save them

        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        }
        catch (EmptyResultDataAccessException e) {

        }
    }
}
