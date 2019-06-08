package com.n2015942084.main;

import com.n2015942084.main.domain.Basic;
import com.n2015942084.main.domain.Profile;
import com.n2015942084.main.repository.BasicRepository;
import com.n2015942084.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository,ProfileRepository profileRepository)
	{
		return (args -> IntStream.rangeClosed(1,5).forEach(index->{
			basicRepository.save(Basic.builder()
			.name("홍길동"+index)
			.label("CEO"+index)
			.email("hong@gmail.com")
			.phone("012-3456-7890")
			.build());

			IntStream.rangeClosed(1,1).forEach(index2->{
			profileRepository.save(Profile.builder()
			.netWork("트위터")
			.userName("@home")
			.url("https://www.twitter.com/@home")
			.createDate(LocalDateTime.now())
			.build());
		});

		}));

	}
}
