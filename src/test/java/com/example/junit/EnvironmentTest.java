package com.example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class,
    initializers = EnvironmentTest.MockPropertiesInitailizer.class )
public class EnvironmentTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void environment(){
        assertEquals("I'm the king",applicationContext.getBean("message"));
    }

    public static class MockPropertiesInitailizer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
         /*   MockEnvironment mockEnvironment = new MockEnvironment();
            mockEnvironment.setProperty("message","I'm the mockstar");
            configurableApplicationContext.setEnvironment(mockEnvironment);*/
            MutablePropertySources propertySources = configurableApplicationContext.getEnvironment().getPropertySources();
            MockPropertySource mockPropertySource = new MockPropertySource().withProperty("message","I'm the mockstar");
            propertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,mockPropertySource);
        }
    }
}
