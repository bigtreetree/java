package aaron.cheng.mybatis.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@MapperScan(basePackages = KidoDataDbConfig.Package, sqlSessionFactoryRef = "kidoDataSqlSessionFactory")
public class KidoDataDbConfig {
    static final String Package = "aaron.cheng.mybatis.dao.kidodata";

    @Value("${datasource.kidodata.readprefix}")
    private String readPrefix;
    @Value("${datasource.kidodata.writeprefix}")
    private String writePrefix;

    @Bean(name = "kidoDataMasterDataSource")
    @ConfigurationProperties(prefix = "datasource.kidodata.master")
    public DataSource kidoDataMasterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "kidoDataSlaveDataSource")
    @ConfigurationProperties(prefix = "datasource.kidodata.slave")
    public DataSource kidoDataSlaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "kidoDataDataSource")
    public DynamicDataSource kidoDataDataSource(@Qualifier("kidoDataMasterDataSource") DataSource master,
        @Qualifier("kidoDataSlaveDataSource") DataSource slave) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.master, master);
        targetDataSources.put(DatabaseType.slave, slave);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(slave);// 默认的datasource设置为myTestDbDataSource
        dataSource.setMethodType(DatabaseType.slave, readPrefix);
        dataSource.setMethodType(DatabaseType.master, writePrefix);
        return dataSource;
    }

    @Bean(name = "kidoDataSqlSessionFactory")
    public SqlSessionFactory kidoDataSqlSessionFactory(@Qualifier("kidoDataDataSource") DataSource dataSource)
        throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 加载Mybatis配置
        bean.setMapperLocations(resolver.getResources("classpath:mapper/kidodata/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "kidoDataSqlSessionTemplate")
    public SqlSessionTemplate kidoStatisticsSqlSessionTemplate(
        @Qualifier("kidoDataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
