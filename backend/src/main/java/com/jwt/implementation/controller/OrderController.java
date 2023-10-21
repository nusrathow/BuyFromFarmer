package com.jwt.implementation.controller;
import com.jwt.implementation.model.Orders;
import com.jwt.implementation.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    //     CREATE A NEW ORDER

    @RequestMapping(value = "/order",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> createNewOrder(@RequestBody Orders orders) throws URISyntaxException {
        Long maxId= orderRepository.getMaxId();
        Long newId=(maxId==null)?1:(maxId+1);
        orders.setId(newId);
        Orders result= orderRepository.save(orders);
        return ResponseEntity.ok()
                .body(result);
    }


    // UPDATE AN EXISTING ORDER

    @RequestMapping(value = "/order", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> updateOrder(@RequestBody Orders orders) throws URISyntaxException {
        if (orders.getId() == null) {
            return createNewOrder(orders);
        }
        Orders result = orderRepository.save(orders);
        return ResponseEntity.ok()
                .body(result);
    }


    // FIND A ORDER BY ID

    @RequestMapping(value = "/order/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
        return Optional.ofNullable(orderRepository.findById(id))
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

