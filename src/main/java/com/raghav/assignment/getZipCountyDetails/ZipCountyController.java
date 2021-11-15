package com.raghav.assignment.getZipCountyDetails;


import com.raghav.assignment.dto.ZipDto;
import com.raghav.assignment.exception.DataNotFoundException;
import com.raghav.assignment.exception.InvalidArgumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/zipcounty")
@Slf4j
public class ZipCountyController {

    @Autowired
    ZipCountyService zipCountyService;

    @GetMapping("/count")
    public ZipCountyDetails getZipCountyDetails(@Valid @RequestParam("statecode") String statecode) {

       if (statecode.length() != 2) {
            throw new InvalidArgumentException("State-code is always 2 character.");
        } else
        return zipCountyService.getZipCountyDetails(statecode);

    }

    @PutMapping("{zip_code}")
    public ResponseEntity<?> updateZipById(@PathVariable("zip_code") String zip_code, @RequestBody ZipDto zipDto){

        /*log.info("ZipCode : {}", zip_code);
        log.info("ZipDto : {}", zipDto.toString());
        log.info("ZipDto : {}", zip_code.length());*/

        if (zip_code.length() !=5 ) {
            throw new InvalidArgumentException("Zip_code is always of 5 digit.");
        } else
        return  new ResponseEntity<>(zipCountyService.updateZipById(zip_code,zipDto), HttpStatus.OK);

    }


}


