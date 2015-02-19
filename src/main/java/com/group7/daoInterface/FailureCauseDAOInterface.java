package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;
import com.group7.entities.Failure;

@Local
public interface FailureCauseDAOInterface {
	Collection<Failure> getAllFailureCauses();
}
