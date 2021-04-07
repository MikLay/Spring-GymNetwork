package com.spp.gym_network.mainservice.config;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    ConversionService conversionService;


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToTimestamp());
    }

    public static class StringToTimestamp implements Converter<String, Timestamp> {
        @Override
        public Timestamp convert(String rawTimestamp) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parsedDate = simpleDateFormat.parse(rawTimestamp);
                return new Timestamp(parsedDate.getTime());
            } catch (ParseException e) {
                throw new net.kaczmarzyk.spring.data.jpa.utils.Converter.ValueRejectedException(rawTimestamp, "Timestamp format exception, expected format: yyyy-MM-dd HH:mm:ss");
            }
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new SpecificationArgumentResolver(conversionService));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Origin", "Content-Type", "Authorization")
                .allowedOrigins("http://localhost:3000");
    }
}
