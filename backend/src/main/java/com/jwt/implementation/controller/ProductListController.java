package com.jwt.implementation.controller;
import com.jwt.implementation.config.FileUploadUtil;
import com.jwt.implementation.model.ProductList;
import com.jwt.implementation.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

    @CrossOrigin(origins = "http://localhost:4200")
    @RestController
    @RequestMapping("/api")
    public class ProductListController {

        @Autowired
        private ProductListRepository productListRepository;


        //     CREATE A NEW CATEGORY

        @RequestMapping(value = "/productList",
                method = RequestMethod.POST)
        @ResponseBody
        public ResponseEntity<?> createNewCategory(@RequestBody ProductList productList, @RequestParam("image")MultipartFile multipartFile) throws URISyntaxException, IOException {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            productList.setImage(fileName);
            Long maxId= productListRepository.getMaxId();
            Long newId=(maxId==null)?1:(maxId+1);
            productList.setId(newId);
            ProductList result= productListRepository.save(productList);
            String uploadDir = "productList/"+result.getId();
            FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
            return ResponseEntity.ok()
                    .body(result);
        }


        // UPDATE AN EXISTING CATEGORY

        /*@RequestMapping(value = "/productList", //
                method = RequestMethod.PUT, //
                produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public ResponseEntity<?> updateCategory(@RequestBody ProductList productList) throws URISyntaxException {
            if (productList.getId() == null) {
                return createNewCategory(productList);
            }
            ProductList result = productListRepository.save(productList);
            return ResponseEntity.ok()
                    .body(result);
        }*/


        @GetMapping("/productList")
        public List getAllProduct() {
            return productListRepository.findAll();
        }


        // FIND A PRODUCT BY ID

        @RequestMapping(value = "/productList/{id}", //
                method = RequestMethod.GET, //
                produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
            return Optional.ofNullable(productListRepository.findById(id))
                    .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }


        // FIND PRODUCTS BY CATEGORYID

        @RequestMapping(value = "/productList/productListByCatId/{categoryId}", //
                method = RequestMethod.GET, //
                produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public ResponseEntity<?> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
            return Optional.ofNullable(productListRepository.findProductsByCategoryId(categoryId))
                    .map(farmer -> new ResponseEntity<>(farmer, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

    }

