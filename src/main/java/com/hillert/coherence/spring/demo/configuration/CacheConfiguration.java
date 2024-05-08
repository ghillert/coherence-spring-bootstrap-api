package com.hillert.coherence.spring.demo.configuration;

import com.oracle.coherence.spring.configuration.annotation.EnableCoherence;

import com.oracle.coherence.spring.configuration.session.SessionConfigurationBean;
import com.oracle.coherence.spring.configuration.session.SessionType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCoherence
public class CacheConfiguration {

	@Bean
	SessionConfigurationBean sessionConfigurationBean1() {
		final SessionConfigurationBean sessionConfigurationBean =
				new SessionConfigurationBean();
		sessionConfigurationBean.setType(SessionType.SERVER);
		sessionConfigurationBean.setConfig("coherence-cache-config.xml");
		return sessionConfigurationBean;
	}

	@Bean
	SessionConfigurationBean sessionConfigurationBean2() {
		final SessionConfigurationBean sessionConfigurationBean =
				new SessionConfigurationBean();
		sessionConfigurationBean.setType(SessionType.CLIENT);
		sessionConfigurationBean.setName("secondSession");
		sessionConfigurationBean.setConfig("remote-cache-config.xml");
		return sessionConfigurationBean;
	}

}
