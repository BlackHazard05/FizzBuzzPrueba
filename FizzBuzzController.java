package com.pixvs.main.controllers;

import com.pixvs.spring.models.JsonResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by César Hernandez Soto on 17/08/2020.
 */
@RestController
@RequestMapping("/fizz-buzz")
public class FizzBuzzController {


    @RequestMapping(value = "/convertToFizzBuzz/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResponse convertToFizzBuzz(@PathVariable Integer number)  {
        return new JsonResponse(convertNumberToFizzBuzz(number), null, JsonResponse.STATUS_OK);
    }

    @RequestMapping(value = "/getFizzBuzzSequence/{lastElement}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResponse getFizzBuzzSequence(@PathVariable Integer lastElement)  {
        List<String> sequence = new ArrayList<>();
        for(Integer i=1;i<=lastElement;i++){
            sequence.add(convertNumberToFizzBuzz(i));
        }
        return new JsonResponse(sequence, null, JsonResponse.STATUS_OK);
    }

    public String convertNumberToFizzBuzz(Integer number){
        if(number % 15 == 0){
            return "fizz buzz";
        }else if(number % 5 == 0) {
            return "buzz";
        }
        else if(number % 3 == 0){
            return "fizz";
        }
        return String.valueOf(number);
    }
}
