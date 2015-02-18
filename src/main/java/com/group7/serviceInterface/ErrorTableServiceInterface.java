package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.ErrorTable;

@Local
public interface ErrorTableServiceInterface {

	Collection<ErrorTable> getAllErrorRecords();
}
