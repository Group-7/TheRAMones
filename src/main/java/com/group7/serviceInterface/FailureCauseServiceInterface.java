package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.Failure;


@Local
public interface FailureCauseServiceInterface {

	Collection<Failure> getAllFailureCauses();
}
