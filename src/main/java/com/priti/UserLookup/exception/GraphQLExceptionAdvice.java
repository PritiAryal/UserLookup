package com.priti.UserLookup.exception;


import graphql.GraphQLError;
import graphql.GraphqlErrorException;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;

@ControllerAdvice
public class GraphQLExceptionAdvice{

    @GraphQlExceptionHandler(ResourceNotFoundException.class)
    public GraphQLError handleNotFound(ResourceNotFoundException ex, DataFetchingEnvironment env) {
        return GraphqlErrorException.newErrorException()
                .message(ex.getMessage())
                .path(env.getExecutionStepInfo().getPath().toList())
                .extensions(Map.of("code", "NOT_FOUND"))
                .build();
    }
}
