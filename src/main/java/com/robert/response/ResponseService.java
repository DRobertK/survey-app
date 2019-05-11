package com.robert.response;

import com.robert.response.domain.Response;
import com.robert.response.domain.RespsonseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResponseService {


    private RespsonseRepository respsonseRepository;

    @Autowired
    public ResponseService(RespsonseRepository respsonseRepository) {
        this.respsonseRepository = respsonseRepository;
    }

    //CRUD operations
    @Transactional
    public Response save(Response response) {
        return respsonseRepository.save(response);
    }

    public List<Response> findAll() {
        return respsonseRepository.findAll();
    }

    public Response findById(Long id) {
        return respsonseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("response not found"));
    }

    public void deleteById(Long id) {
        respsonseRepository.deleteById(id);
    }
}
