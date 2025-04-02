package com.example.library.kata;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LibraryKataApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LibraryKataApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

}
