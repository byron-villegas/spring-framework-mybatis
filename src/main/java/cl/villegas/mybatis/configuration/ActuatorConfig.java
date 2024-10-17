package cl.villegas.mybatis.configuration;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricExportAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricsChannelAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricsDropwizardAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.PublicMetricsAutoConfiguration;
import org.springframework.boot.actuate.endpoint.BeansEndpoint;
import org.springframework.boot.actuate.endpoint.ConfigurationPropertiesReportEndpoint;
import org.springframework.boot.actuate.endpoint.DumpEndpoint;
import org.springframework.boot.actuate.endpoint.EnvironmentEndpoint;
import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.actuate.endpoint.InfoEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.RequestMappingEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMapping;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.MvcEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:actuator.properties")
@Import({ EndpointAutoConfiguration.class, HealthIndicatorAutoConfiguration.class, MetricExportAutoConfiguration.class,
		MetricFilterAutoConfiguration.class, MetricsChannelAutoConfiguration.class,
		MetricsDropwizardAutoConfiguration.class, MetricRepositoryAutoConfiguration.class,
		PublicMetricsAutoConfiguration.class })
public class ActuatorConfig {
	@Bean
	@Autowired
	public EndpointHandlerMapping endpointHandlerMapping(Collection<? extends MvcEndpoint> endpointHandlerMapping) {
		return new EndpointHandlerMapping(endpointHandlerMapping);
	}

	@Bean
	@Autowired
	public HealthMvcEndpoint healthMvcEndpoint(HealthEndpoint healthEndpoint) {
		return new HealthMvcEndpoint(healthEndpoint, false);
	}

	@Bean
	@Autowired
	public MetricsMvcEndpoint metricsMvcEndpoint(MetricsEndpoint metricsEndpoint) {
		return new MetricsMvcEndpoint(metricsEndpoint);
	}

	@Profile("!production")
	@Bean
	@Autowired
	public EnvironmentMvcEndpoint environmentMvcEndpoint(EnvironmentEndpoint environmentEndpoint) {
		return new EnvironmentMvcEndpoint(environmentEndpoint);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter infoMvcEndPoint(InfoEndpoint infoEndpoint) {
		return new EndpointMvcAdapter(infoEndpoint);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter beansEndPoint(BeansEndpoint beansEndpoint) {
		return new EndpointMvcAdapter(beansEndpoint);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter dumpEndPoint(DumpEndpoint dumpEndpoint) {
		return new EndpointMvcAdapter(dumpEndpoint);
	}

	@Profile("!production")
	@Bean
	@Autowired
	public EndpointMvcAdapter configurationPropertiesEndPoint(ConfigurationPropertiesReportEndpoint configurationPropertiesReportEndpoint) {
		return new EndpointMvcAdapter(configurationPropertiesReportEndpoint);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter requestMappingEndPoint(RequestMappingEndpoint requestMappingEndpoint) {
		return new EndpointMvcAdapter(requestMappingEndpoint);
	}
}