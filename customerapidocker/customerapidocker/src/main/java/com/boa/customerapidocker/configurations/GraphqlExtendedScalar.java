package com.boa.customerapidocker.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
@Configuration
public class GraphqlExtendedScalar {
	@Bean
    public GraphQLScalarType dateType(){
        return ExtendedScalars.Date;
    }
    @Bean
    public GraphQLScalarType jsonType(){
        return ExtendedScalars.Json;
    }

}
