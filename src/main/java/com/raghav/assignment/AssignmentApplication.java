package com.raghav.assignment;

import com.google.gson.Gson;
import com.raghav.assignment.getzipdetails.ZipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AssignmentApplication implements CommandLineRunner {

	@Autowired
	Gson gson;

	@Autowired
	ZipService zipService;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		zipService.loadCsvZipData();

	}


}
