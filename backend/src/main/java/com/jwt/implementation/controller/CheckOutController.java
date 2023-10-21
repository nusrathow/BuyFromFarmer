package com.jwt.implementation.controller;
import com.jwt.implementation.model.CheckOut;
import com.jwt.implementation.repository.CheckOutRepository;
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
public class CheckOutController{

    @Autowired
    private CheckOutRepository checkOutRepository;


    //     CREATE A NEW CHECKOUT

    @RequestMapping(value = "/checkOut",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> createNewCheckOut(@RequestBody CheckOut checkOut) throws URISyntaxException {
        Long maxId= checkOutRepository.getMaxId();
        Long newId=(maxId==null)?1:(maxId+1);
        checkOut.setId(newId);
        CheckOut result= checkOutRepository.save(checkOut);
        return ResponseEntity.ok()
                .body(result);
    }


    // UPDATE AN EXISTING CHECKOUT

    @RequestMapping(value = "/checkOut", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> updateOrder(@RequestBody CheckOut checkOut) throws URISyntaxException {
        if (checkOut.getId() == null) {
            return createNewCheckOut(checkOut);
        }
        CheckOut result = checkOutRepository.save(checkOut);
        return ResponseEntity.ok()
                .body(result);
    }


    // FIND A CHECKOUT BY ID

    @RequestMapping(value = "/checkOut/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getCheckOutById(@PathVariable("id") Long id) {
        return Optional.ofNullable(checkOutRepository.findById(id))
                .map(checkOut -> new ResponseEntity<>(checkOut, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
