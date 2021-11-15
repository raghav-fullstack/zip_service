package com.raghav.assignment.getzipdetails;

import com.raghav.assignment.dto.ZipDto;
import com.raghav.assignment.entity.ZipEntity;
import com.raghav.assignment.repository.ZipRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ZipService {

    @Autowired
    ZipRepository zipRepository;

    public void loadCsvZipData() throws IOException {

        List<ZipDto> collectZipDto = new ArrayList<>();
        List<ZipEntity> collectZipEntity = new ArrayList<>();
        File file = new File("D:\\SpringBoot\\assignment\\us_zip.csv");
        CSVFormat fileCsvFormat = CSVFormat.EXCEL;
        FileInputStream fileInputStream = new FileInputStream(file);


        Reader in = new FileReader("D:\\SpringBoot\\assignment\\us_zip.csv");

        Reader inputStream = new InputStreamReader(fileInputStream);


        CSVParser csvParser = new CSVParser(inputStream, fileCsvFormat);

        List<CSVRecord> csvRecordList = csvParser.stream().collect(Collectors.toList());

        //log.info("CSV Parser Count" + String.valueOf(csvRecordList.size()));

        for (CSVRecord csvRecords : csvRecordList) {

            collectZipDto.add(new ZipDto().builder()
                    .countryCode(csvRecords.get(0)).zipCode(csvRecords.get(1))
                    .placeName(csvRecords.get(2)).stateName(csvRecords.get(3))
                    .stateCode(csvRecords.get(4)).county(csvRecords.get(5))
                    .province(csvRecords.get(6)).community1(csvRecords.get(7))
                    .community2(csvRecords.get(8)).latitude(Double.parseDouble(csvRecords.get(9)))
                    .longitude(Double.parseDouble(csvRecords.get(10)))

                    //.accuracy(Integer.parseInt(csvRecords.get(11))>=0?Integer.parseInt(csvRecords.get(11)):0)
                    .accuracy(Integer.parseInt(StringUtils.defaultIfBlank(csvRecords.get(11), "0")))
                    .build()
            );

        }


        for (ZipDto zipDto : collectZipDto) {
            collectZipEntity.add(
                    new ZipEntity().builder()
                            .countryCode(zipDto.getCountryCode())
                            .zipCode(Integer.parseInt(zipDto.getZipCode()))
                            .placeName(zipDto.getPlaceName())
                            .stateName(zipDto.getStateName())
                            .stateCode(zipDto.getStateCode())
                            .county(zipDto.getCounty())
                            .province(zipDto.getProvince())
                            .community1(zipDto.getCommunity1())
                            .community2(zipDto.getCommunity2())
                            .latitude(zipDto.getLatitude())
                            .longitude(zipDto.getLongitude())
                            .accuracy(zipDto.getAccuracy())
                            .build()
            );
        }


        /*System.out.println("\n\n After adding ZipDto to collection\t:" + collectZipDto.size());
        System.out.println("\n\n After adding ZipDto to collection\t:" + collectZipEntity.size());

        System.out.println("\n\n Getting first ZipDto from collection \t:" + collectZipDto.get(0));
        System.out.println("\n\n Getting first ZipEntity from collection \t:" + collectZipEntity.get(0));*/

        zipRepository.saveAll(collectZipEntity);

        /*System.out.println("\n This is before calling of saveAll() method");
        System.out.println("\n This is after calling of saveAll() method");*/
    }

    public ZipDetails getZipDetails(int zip) {

        ZipDetails zipDetails = new ZipDetails();

        log.debug("Zip which is requested :{}",zip);

        ZipEntity tempZip = zipRepository.findByZip(zip);

        BeanUtils.copyProperties(tempZip,zipDetails);

        log.debug("ZipDetails County :{}",zipDetails);


        return zipDetails;
    }
}
