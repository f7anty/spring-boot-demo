package com.example.demo.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.IdGenerator;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * 主数据源
     *
     * @return
     */
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(masterDataSource());
        return dataSourceTransactionManager;
    }

    @Bean(name = "masterSqlSessionFactory")
    @ConditionalOnMissingBean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean masterSqlSessionFactory = new MybatisSqlSessionFactoryBean();
        masterSqlSessionFactory.setDataSource(masterDataSource());
        masterSqlSessionFactory.setTypeAliasesPackage("com.example.demo.model");
        //masterSqlSessionFactory.setMapperLocations(masterMapperLocations());
        masterSqlSessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);


        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        //configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        masterSqlSessionFactory.setConfiguration(configuration);

        return masterSqlSessionFactory.getObject();
    }

    @Bean(name = "sqlSession")
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(masterSqlSessionFactory());
    }

    private Resource[] masterMapperLocations() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] mapperResourceArray = resolver.getResources("classpath*:/com/example/demo/mapper/**/*.xml");
            return mapperResourceArray;
        } catch (IOException e) {
            logger.info("scan master mapper has error, msg:{}.", e);
        }
        return null;
    }

}
