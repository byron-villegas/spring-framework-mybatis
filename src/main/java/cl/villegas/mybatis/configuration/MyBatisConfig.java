package cl.villegas.mybatis.configuration;

import javax.sql.DataSource;
import cl.villegas.mybatis.constants.Constants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cl.villegas.mybatis.repository")
public class MyBatisConfig {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
		try {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			sqlSessionFactoryBean.setTypeAliasesPackage(Constants.MyBatis.TYPE_ALIASES_PACKAGE);
			sqlSessionFactoryBean.setTypeHandlersPackage(Constants.MyBatis.TYPE_HANDLERS_PACKAGE);
			return sqlSessionFactoryBean.getObject();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}