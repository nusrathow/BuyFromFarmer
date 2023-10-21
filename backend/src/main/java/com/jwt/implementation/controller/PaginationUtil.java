package com.jwt.implementation.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class PaginationUtil {
    @Bean
    public PaginationUtil PaginationUtil() {
        return new PaginationUtil();
    }

    public Pageable listPage(Page<?> page, String sortBy){
        Pageable paging = PageRequest.of(page.getNumber(), page.getSize(), Sort.by(sortBy).descending());
        return paging;
    }

    public static HttpHeaders generatePaginationHttpHeaders(Page<?> page, String baseUrl)
            throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotalElements());
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + (new URI(baseUrl +"?page=" + (page.getNumber() + 1) + "&size=" + page.getSize())).toString() + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + (new URI(baseUrl +"?page=" + (page.getNumber() - 1) + "&size=" + page.getSize())).toString() + ">; rel=\"prev\",";
        }
        // last and first link
        link += "<" + (new URI(baseUrl +"?page=" + (page.getTotalPages() - 1) + "&size=" + page.getSize())).toString() + ">; rel=\"last\",";
        link += "<" + (new URI(baseUrl +"?page=" + 0 + "&size=" + page.getSize())).toString() + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }
}
