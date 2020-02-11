package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.apache.commons.lang3.StringUtils;


@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
@ConfigurationProperties(prefix = "spring.session.cookie")
public class SessionConfig {

    private String domainName;

    private String cookieName;

    private String cookiePath;

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        if (StringUtils.isNotEmpty(domainName)) {
            defaultCookieSerializer.setDomainName(domainName);
        }
        defaultCookieSerializer.setCookieName(cookieName);
        defaultCookieSerializer.setCookiePath(cookiePath);
        return defaultCookieSerializer;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public void setCookiePath(String cookiePath) {
        this.cookiePath = cookiePath;
    }
}
