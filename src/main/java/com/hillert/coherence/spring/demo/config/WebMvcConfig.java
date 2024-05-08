/*
 * Copyright (c) 2020, 2022, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */
package com.hillert.coherence.spring.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Gunnar Hillert
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.hillert.coherence.spring.demo.controller")
public class WebMvcConfig implements WebMvcConfigurer {

}
