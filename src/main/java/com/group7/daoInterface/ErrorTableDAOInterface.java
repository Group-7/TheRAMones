package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.ErrorTable;

@Local
public interface ErrorTableDAOInterface {

	Collection<ErrorTable> getAllErrorRecords();
}
