package com.hillert.coherence.spring.demo.controller;

import com.oracle.coherence.spring.configuration.annotation.CoherenceCache;
import com.tangosol.net.NamedCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

	private final NamedCache<String, Integer> greetingCache;
	private final NamedCache<String, Integer> secondCache;

	public HelloController(
			@CoherenceCache NamedCache<String, Integer> greetingCache,
			@CoherenceCache(session = "secondSession") NamedCache<String, Integer> secondCache) {
		this.greetingCache = greetingCache;
		this.secondCache = secondCache;
	}

	@RequestMapping("/")
	public String index(@RequestParam(value = "second", required = false) boolean useSecondCache) {

		final NamedCache<String, Integer> cacheToUse;

		if (useSecondCache) {
			cacheToUse = secondCache;
		}
		else {
			cacheToUse = greetingCache;
		}

		Integer counter = cacheToUse.getOrDefault("counter", 0);
		counter++;

		cacheToUse.put("counter", counter);

		LOGGER.info("Counter: {}.", counter);
		return "Greetings from Coherence! " + counter;
	}
}
