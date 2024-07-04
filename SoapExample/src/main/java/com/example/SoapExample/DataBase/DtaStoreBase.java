package com.example.SoapExample.DataBase;
import com.example.SoapExample.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackageClasses = com.example.SoapExample.Repo.EmployeeRepo.class)
@ComponentScan(value = "com.example.SoapExample.*")
@EntityScan(basePackages = "com.example.SoapExample.Model")
public class DtaStoreBase {


    @Value("spring.datasource.url")
    String url;

    @Value("spring.datasource.username")
    String username;

    @Value("spring.datasource.password")
    String password;

    @Value("spring.datasource.driver-class-name")
    String DriverClass;


    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
        managerDataSource.setUrl(url);
        managerDataSource.setUsername(username);
        managerDataSource.setPassword(password);
        managerDataSource.setDriverClassName(DriverClass);
        return managerDataSource;
    }


}
