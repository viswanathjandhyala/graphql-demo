package com.demo.graphql.repo;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;

public class DefaultGraphQLErrorHandler implements GraphQLErrorHandler {

	public static final Logger log = LoggerFactory.getLogger(DefaultGraphQLErrorHandler.class);
			
	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		final List<GraphQLError> clientErrors = filterGraphQLErrors(errors);
		if (clientErrors.size() < errors.size()) {
			clientErrors.add(new GenericGraphQLError("Internal Server Error(s) while executing query"));
			errors.stream()
			.filter(error -> !isClientError(error))
			.forEach(error -> {
				if(error instanceof Throwable) {
					log.error("Error executing query!", (Throwable) error);
				} else {
					log.error("Error executing query ({}): {}", error.getClass().getSimpleName(), error.getMessage());
				}
			});
		}
		return clientErrors;
	}
	
	protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
            .filter(this::isClientError)
            .collect(Collectors.toList());
    }

    protected boolean isClientError(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            return ((ExceptionWhileDataFetching) error).getException() instanceof GraphQLError;
        }
        return !(error instanceof Throwable);
    }
}
