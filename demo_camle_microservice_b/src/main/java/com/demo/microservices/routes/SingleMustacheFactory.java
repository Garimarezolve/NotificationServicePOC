package com.demo.microservices.routes;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
@Configuration
public class SingleMustacheFactory {

    public static MustacheFactory getMustacheFactory() {

        return new DefaultMustacheFactory();

    }

}