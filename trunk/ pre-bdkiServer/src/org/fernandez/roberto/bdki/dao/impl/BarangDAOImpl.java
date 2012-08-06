package org.fernandez.roberto.bdki.dao.impl;

import org.fernandez.roberto.bdki.dao.BarangDAO;
import org.fernandez.roberto.bdki.dao.core.impl.CoreDAOImpl;
import org.fernandez.roberto.bdki.entities.TBarang;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BarangDAOImpl extends CoreDAOImpl<TBarang> implements BarangDAO {
	/**
	 * Default constructor.
	 * 
	 * @param sessionFactory
	 *            the session factory
	 */
	@Autowired
	public BarangDAOImpl(SessionFactory sessionFactory) {
		super(TBarang.class, sessionFactory);
	}
}
