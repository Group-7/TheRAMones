package com.group7.daoInterface;

import java.util.Collection;

import com.group7.entities.Failure;

public interface FailureDAOInterface {
	Failure getFailure(Integer FailureCode);
	Collection<Failure> getAllFailures();
}