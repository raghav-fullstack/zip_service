package com.raghav.assignment.getZipCountyDetails;


import com.raghav.assignment.common.ResponseMessage;
import com.raghav.assignment.dto.ZipDto;
import com.raghav.assignment.entity.ZipEntity;
import com.raghav.assignment.exception.DataNotFoundException;
import com.raghav.assignment.repository.ZipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ZipCountyService {

    @Autowired
    ZipRepository zipRepository;

    public ZipCountyDetails getZipCountyDetails(String statecode) {

        ZipCountyDetails zipCountyDetails = new ZipCountyDetails();

        log.debug("State Code details :{} ", statecode);

        List<ZipEntity> tempZipCounty = zipRepository.findZipCountyDetailsZipStateCode(statecode);

        if (tempZipCounty.isEmpty())
            throw new DataNotFoundException(String.format("No Records Found for : %s ", statecode));

        //log.debug(String.valueOf("\n No. of records: \t"+tempZipCounty.stream().count()));
        //log.debug(String.valueOf("\n First records: \t "+tempZipCounty.get(0)));

        //BeanUtils.copyProperties(CollectionUtils.firstElement(tempZipCounty),zipCountyDetails);


        zipCountyDetails.setStateName(CollectionUtils.firstElement(tempZipCounty).getStateName());
        zipCountyDetails.setStateCode(CollectionUtils.firstElement(tempZipCounty).getStateCode());


        zipCountyDetails.setNumberOfCounties(tempZipCounty.stream().map(x -> x.getCounty()).collect(Collectors.toList()).stream().distinct().count());


        //zipCountyDetails.setNumberOfZipCodes(tempZipCounty.stream().map(x->x.getZipCode()).collect(Collectors.toList()).stream().distinct().count());

        zipCountyDetails.setNumberOfZipCodes(tempZipCounty.stream().map(x -> x.getZipCode()).distinct().count());

        return zipCountyDetails;
    }

    public Object updateZipById(String zip_code, ZipDto zipDto) {



        ZipEntity zipEntity;

        zipEntity = zipRepository.findByZip(Integer.parseInt(zip_code));

        if (zipEntity == null)
            throw new DataNotFoundException(String.format("No Records Found for : %s", zip_code));
        else {
            BeanUtils.copyProperties(zipDto, zipEntity);
            zipRepository.save(zipEntity);

        }

       /* zipRepository.findByZip(Integer.parseInt(zip_code))==null?throw new DataNotFoundException(String.format("No Records Found for : %s", zip_code)):
        zipRepository.save(BeanUtils.copyProperties(zipDto, zipEntity));*/


        return ResponseMessage.builder().responseMessage("Records has been updated").httpStatus(HttpStatus.ACCEPTED).id(String.format("Zip_code : %s",zip_code)).build();
    }
}
