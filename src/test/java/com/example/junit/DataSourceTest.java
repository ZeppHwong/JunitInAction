package com.example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.NamingException;
import javax.sql.DataSource;


import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test/applicationContext.xml",
    initializers = DataSourceTest.MockJeeLookupInitializer.class)
public class DataSourceTest {
    @Autowired
    ApplicationContext context;


    @Test
    public void jndiResouce(){
        assertNotNull(context.getBean("common-Datasource"));
    }

    public static class MockJeeLookupInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            DataSource mockDataSource =  Mockito.mock(DataSource.class);
            SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
            builder.bind("java:comp/env/Datasource",mockDataSource);

            try {
                builder.activate();
            } catch (NamingException e) {
                e.printStackTrace();
            }

        }
    }
}
