package org.fernandez.roberto.bdki.dao.impl;

import org.fernandez.roberto.bdki.dao.VendorDAO;
import org.fernandez.roberto.bdki.dao.core.impl.CoreDAOImpl;
import org.fernandez.roberto.bdki.entities.TVendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAOImpl extends CoreDAOImpl<TVendor> implements VendorDAO {
	/**
	 * Default constructor.
	 * 
	 * @param sessionFactory
	 *            the session factory
	 */
	@Autowired
	public VendorDAOImpl(SessionFactory sessionFactory) {
		super(TVendor.class, sessionFactory);
	}
}
