package me.christ9979.springbootjpa2;

import me.christ9979.springbootjpa2.common.repository.BaseCommonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseCommonRepository.class)
public class SpringBootJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa2Application.class, args);
	}

}

