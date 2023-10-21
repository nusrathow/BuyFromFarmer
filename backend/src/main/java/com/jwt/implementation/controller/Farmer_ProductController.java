package com.jwt.implementation.controller;

import com.jwt.implementation.model.Farmer;
import com.jwt.implementation.model.Product;
import com.jwt.implementation.repository.FarmerRepository;
import com.jwt.implementation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Farmer_ProductController {

    @Autowired
    private FarmerRepository farmerRepository;
    private ProductRepository productRepository;

    @Autowired
    PaginationUtil paginationUtil;

    public Farmer_ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //     CREATE A NEW FARMER

    @RequestMapping(value = "/farmer",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody

    public ResponseEntity<?> createNewFarmer(@RequestBody Farmer farmer) throws URISyntaxException {
        Long maxId= farmerRepository.getMaxId();
        Long newId=(maxId==null)?1:(maxId+1);
        farmer.setId(newId);
        Farmer result= farmerRepository.save(farmer);
        return ResponseEntity.ok()
                .body(result);
    }


    // UPDATE AN EXISTING FARMER

    @RequestMapping(value = "/farmer", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> updateFarmer(@RequestBody Farmer farmer) throws URISyntaxException {
        if (farmer.getId() == null) {
            return createNewFarmer(farmer);
        }
        Farmer result = farmerRepository.save(farmer);
        return ResponseEntity.ok()
                .body(result);
    }


    @RequestMapping(value = "/farmer", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getAllFarmer(Pageable pageable) throws URISyntaxException {

        Page<Farmer> page = farmerRepository.findAll(pageable);
        page= farmerRepository.findAll(paginationUtil.listPage(page,"id"));

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/farmer");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }


    @GetMapping("/farmer/allFarmer")
    public List getAllFarmer() {
        return farmerRepository.findAll();
    }


    // FIND A FARMER BY ITS ID

    @RequestMapping(value = "/farmer/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getFarmerById(@PathVariable("id") Long id) {
        return Optional.ofNullable(farmerRepository.findById(id))
                .map(farmer -> new ResponseEntity<>(farmer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    // FIND ALL PRODUCT BY PRODUCTLIST ID

    @RequestMapping(value = "/product/{productList}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<List> getAllProductById(@PathVariable("productList") Long productList) {
        List<Product> list =productRepository.findAllProductById(productList);
        return ResponseEntity.ok().body(list);
    }


    // FIND A FARMER BY ITS ID

    @RequestMapping(value = "/product/productById/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        return Optional.ofNullable(productRepository.findById(id))
                .map(farmer -> new ResponseEntity<>(farmer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
