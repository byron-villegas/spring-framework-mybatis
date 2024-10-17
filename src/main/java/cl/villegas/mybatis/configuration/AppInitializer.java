package cl.villegas.mybatis.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import cl.villegas.mybatis.constants.Constants;
import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import cl.villegas.mybatis.enums.App;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private final String[] SERVLET_MAPPINGS_VALUES = new String[] { "/*" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return SERVLET_MAPPINGS_VALUES;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter(Constants.Spring.PROFILE_PROPERTY, Constants.Spring.DEFAULT_PROFILE);
		super.onStartup(servletContext);

		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(Constants.H2.CONTEXT_ROOT_PATH, new WebServlet());
		servletRegistration.setLoadOnStartup(2);
		servletRegistration.addMapping(Constants.H2.MAPPING); // JDBC URL jdbc:h2:mem:testdb
	}
}