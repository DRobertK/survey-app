package com.robert.response.rest;

import com.robert.response.ResponseService;
import com.robert.response.domain.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ResponseController.API_RESPONSE)
public class ResponseController {

    public static final String API_RESPONSE = "/api/response";

    private static final Logger logger = LoggerFactory.getLogger(ResponseController.class.getName());

    private ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public List<Response> findAll() {
        return responseService.findAll();
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable final Long id) {
        logger.debug("find by id {}", id);
        return responseService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Response response) {
        responseService.save(response);
    }

    @PutMapping
    public Response update(@RequestBody Response response) {
        return responseService.save(response);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        responseService.deleteById(id);
    }


}
