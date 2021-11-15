package com.raghav.assignment.getzipdetails;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zips")
@Slf4j
public class ZipController {

    @Autowired
    ZipService zipService;

    @GetMapping("/zip_details")
    public ZipDetails getZipDetails(@RequestParam("zipcode") String zip){

        //log.info("This is for Zip Details.");
        //return null;
        log.info("This is zip being passed :{}", zip);

        return zipService.getZipDetails(Integer.valueOf(zip));
    }
}
