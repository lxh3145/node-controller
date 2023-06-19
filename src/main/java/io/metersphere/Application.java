package io.metersphere;

import io.metersphere.api.config.KafkaProperties;
import io.metersphere.api.jmeter.utils.CommonBeanFactory;
import io.metersphere.api.jmeter.utils.JmeterProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@ServletComponentScan
@EnableConfigurationProperties({
        KafkaProperties.class,
        JmeterProperties.class,
})
//prod
@PropertySource(value = {"file:/opt/metersphere/conf/metersphere.properties"}, encoding = "UTF-8", ignoreResourceNotFound = true)
//dev
//@PropertySource(value = {"file:E:\\idea_project\\metersphere1.12\\backend\\src\\main\\resources\\metersphere.properties"}, encoding = "UTF-8", ignoreResourceNotFound = true)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @ConditionalOnMissingBean
    public CommonBeanFactory commonBeanFactory() {
        return new CommonBeanFactory();
    }
}
