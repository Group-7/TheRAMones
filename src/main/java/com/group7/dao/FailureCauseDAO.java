package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import com.group7.entities.Failure;

@Local
public interface FailureCauseDAO {
	Collection<Failure> getAllFailureCauses();
}
