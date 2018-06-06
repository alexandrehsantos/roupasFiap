package br.com.fiap.roupas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@Import({
//        DispatcherServletAutoConfiguration.class,
//        EmbeddedServletContainerAutoConfiguration.class,
//        ErrorMvcAutoConfiguration.class,
//        HttpEncodingAutoConfiguration.class,
//        HttpMessageConvertersAutoConfiguration.class,
//        JacksonAutoConfiguration.class,
//        JmxAutoConfiguration.class,
//        MultipartAutoConfiguration.class,
//        ServerPropertiesAutoConfiguration.class,
//        PropertyPlaceholderAutoConfiguration.class,
//        ThymeleafAutoConfiguration.class,
//        WebMvcAutoConfiguration.class,
//        WebSocketAutoConfiguration.class,
//})
@SpringBootApplication
public class RoupasfiapApplication {
	// Start in debug mode
	// mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug
	// -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

	public static void main(String[] args) {
		SpringApplication.run(RoupasfiapApplication.class, args);
	}
}
