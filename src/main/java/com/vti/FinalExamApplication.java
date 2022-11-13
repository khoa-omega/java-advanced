package com.vti;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(AccountCreateForm.class, Account.class)
                .addMappings(mapper -> mapper.skip(Account::setId));
        return modelMapper;
    }

    @Bean
    public ObjectWriter objectWriter() {
        return new ObjectMapper()
                .findAndRegisterModules()
                .writerWithDefaultPrettyPrinter();
    }
}
