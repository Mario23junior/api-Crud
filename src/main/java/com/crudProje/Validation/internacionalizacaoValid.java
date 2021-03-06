package com.crudProje.Validation;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class internacionalizacaoValid {
        
	  @Bean
	  public MessageSource messageSource() {
			   ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
			   messageSource.setBasename("classpath:messagesValid");
			   messageSource.setDefaultEncoding("ISO-8859-1");
			   messageSource.setDefaultLocale(Locale.getDefault());
			   return messageSource;
	  }
	  
	  @Bean
	  public LocalValidatorFactoryBean validatorFactoryBean() {
		  LocalValidatorFactoryBean bean =  new LocalValidatorFactoryBean(); 
		  bean.setValidationMessageSource(messageSource());
		  return bean;
	  }
}
