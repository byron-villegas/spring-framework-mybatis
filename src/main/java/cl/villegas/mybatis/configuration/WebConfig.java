package cl.villegas.mybatis.configuration;

import javax.sql.DataSource;
import cl.villegas.mybatis.constants.Constants;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "cl.villegas.mybatis")
@ImportResource({ "classpath:application-context.xml" })
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
		resourceHandlerRegistry.addResourceHandler(Constants.Swagger.PAGE).addResourceLocations(Constants.Swagger.RESOURCES_PATH);
		resourceHandlerRegistry.addResourceHandler(Constants.Web.JAR_PATH).addResourceLocations(Constants.Web.JAR_RESOURCES_PATH);
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix(Constants.Resolver.PREFIX);
		internalResourceViewResolver.setSuffix(Constants.Resolver.SUFFIX);
		return internalResourceViewResolver;
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(Constants.DataSource.GENERATE_UNIQUE_NAME)
				.setName(Constants.DataSource.NAME)
				.setType(EmbeddedDatabaseType.H2)
				.addDefaultScripts()
				.setScriptEncoding(Constants.DataSource.SCRIPT_ENCODING)
				.ignoreFailedDrops(Constants.DataSource.IGNORE_FAILED_DROPS)
				.build();
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(Constants.MultiPartResolver.MAX_UPLOAD_SIZE * 2);
		commonsMultipartResolver.setMaxUploadSizePerFile(Constants.MultiPartResolver.MAX_UPLOAD_SIZE);
		return commonsMultipartResolver;
	}

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath(Constants.FreeMarkerConfigurer.TEMPLATE_LOADER_PATH);
		freeMarkerConfigurer.setDefaultEncoding(Constants.FreeMarkerConfigurer.ENCODING);
		return freeMarkerConfigurer;
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(Constants.CorsConfiguration.ALLOW_CREDENTIALS);
		corsConfiguration.addAllowedOrigin(Constants.CorsConfiguration.ALLOWED_ORIGIN);
		corsConfiguration.addAllowedHeader(Constants.CorsConfiguration.ALLOWED_HEADER);
		corsConfiguration.addAllowedMethod(Constants.CorsConfiguration.ALLOWED_METHOD);
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration(Constants.CorsConfigurationSource.PATH, corsConfiguration);
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(urlBasedCorsConfigurationSource));
		filterRegistrationBean.setOrder(0);
		return filterRegistrationBean;
	}
}