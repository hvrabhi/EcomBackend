package org.spring.DAO;

import java.util.List;

import org.spring.model.Supplier;

public interface SupplierDAO {

	public boolean addSupplier(Supplier supplier);
	public List<Supplier> retrieveSupplier();
}
