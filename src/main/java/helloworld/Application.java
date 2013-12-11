package helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan
public class Application {

    @Bean
    public Properties appInfoProperties() throws IOException {
        return PropertiesLoaderUtils.loadProperties(new ClassPathResource("appinfo.properties"));
    }
}
