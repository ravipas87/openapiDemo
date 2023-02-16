package com.ravipas.openapiDemo;

import com.ravipas.openapiDemo.api.ApiUtil;
import com.ravipas.openapiDemo.api.PetsApiDelegate;
import com.ravipas.openapiDemo.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@RestController
public class PetsApiImpl implements PetsApiDelegate {
    @Override
    public ResponseEntity<List<Pet>> listPets(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : 0, \"tag\" : \"tag\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }
}