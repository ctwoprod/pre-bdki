package org.fernandez.roberto.bdki.services;

import java.util.ArrayList;
import java.util.List;

import org.fernandez.roberto.bdki.dao.impl.VendorDAOImpl;
import org.fernandez.roberto.bdki.entities.TVendor;
import org.fernandez.roberto.bdki.helper.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendorService {
	private VendorDAOImpl vendorDAO;
	private JsonUtil<TVendor> util;

	// get all vendor
	@Transactional(readOnly = true)
	public List<TVendor> getVendorList() {
		return vendorDAO.findAll(null);
	}

	// create new vendor
	// @param data - json data from request
	@Transactional
	public List<TVendor> create(Object data) {
		List<TVendor> returnVendors = new ArrayList<TVendor>();
		List<TVendor> addedVendors = util.getTsFromRequest(data);
		for (TVendor vendor : addedVendors) {
			returnVendors.add(vendorDAO.insert(vendor));
		}
		return returnVendors;
	}

	// update vendor
	// @param data - json data from request
	@Transactional
	public List<TVendor> update(Object data) {

		List<TVendor> returnVendors = new ArrayList<TVendor>();

		List<TVendor> updatedVendors = util.getTsFromRequest(data);

		for (TVendor vendor : updatedVendors) {
			returnVendors.add(vendorDAO.insert(vendor));
		}

		return returnVendors;
	}

	// delete
	// @param data - json data from request
	@Transactional
	public void delete(Object data) {

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			List<Long> deleteVendors = util.getListIdFromJSON(data);

			for (Long id : deleteVendors) {
				vendorDAO.remove(id);
			}

		} else { // it is only one object - cast to object/bean

			Integer id = Integer.parseInt(data.toString());

			vendorDAO.remove(id);
		}
	}

	// DI
	@Autowired
	public void setVendorDAO(VendorDAOImpl vendorDAO) {
		this.vendorDAO = vendorDAO;
	}

	@Autowired
	public void setUtil(JsonUtil<TVendor> util) {
		this.util = util;
		this.util.setT(TVendor.class);
	}
}
