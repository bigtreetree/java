package aaron.cheng.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = KidoStatisticsDbConfig.Package, sqlSessionFactoryRef = "kidoStatisticsDataSqlSessionFactory")
public class KidoStatisticsDbConfig {
    static final String Package = "aaron.cheng.mybatis.dao.kidostatistics";

    @Bean(name = "kidoStatisticsDataSource")
    @ConfigurationProperties(prefix = "datasource.statistics")
    public DataSource kidoStatisticsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "kidoStatisticsTransactionManager")
    public DataSourceTransactionManager kidoStatisticsTransactionManager() {
        return new DataSourceTransactionManager(kidoStatisticsDataSource());
    }

    @Primary
    @Bean(name = "kidoStatisticsDataSqlSessionFactory")
    public SqlSessionFactory kidoStatisticsSqlSessionFactory(
        @Qualifier("kidoStatisticsDataSource") DataSource masterDataSource) throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(masterDataSource);
        // 加载Mybatis配置
        bean.setMapperLocations(resolver.getResources("classpath:mapper/kidostatistics/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "kidoStatisticsSqlSessionTemplate")
    public SqlSessionTemplate kidoStatisticsSqlSessionTemplate(
        @Qualifier("kidoStatisticsDataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
