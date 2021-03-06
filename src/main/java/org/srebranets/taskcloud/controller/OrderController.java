package org.srebranets.taskcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.srebranets.taskcloud.data.OrderRepository;
import org.srebranets.taskcloud.data.UserRepository;
import org.srebranets.taskcloud.domain.Order;
import org.srebranets.taskcloud.domain.User;
import org.srebranets.taskcloud.prop.OrderProps;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderProps orderProps;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository, OrderProps orderProps) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderProps = orderProps;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user
    ) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);

        orderRepository.save(order);
        sessionStatus.setComplete();

        log.info("Order submitted: " + order);
        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());

        model.addAttribute("orders", orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }
}
