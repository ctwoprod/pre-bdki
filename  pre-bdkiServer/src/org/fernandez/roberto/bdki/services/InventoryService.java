package org.fernandez.roberto.bdki.services;

import java.util.ArrayList;
import java.util.List;

import org.fernandez.roberto.bdki.dao.impl.BarangDAOImpl;
import org.fernandez.roberto.bdki.entities.TBarang;
import org.fernandez.roberto.bdki.helper.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {
	private BarangDAOImpl barangDAO;
	private JsonUtil<TBarang> util;

	// get all barang
	@Transactional(readOnly = true)
	public List<TBarang> getBarangList() {
		return barangDAO.findAll(null);
	}

	// create new barang
	// @param data - json data from request
	@Transactional
	public List<TBarang> create(Object data) {
		List<TBarang> returnBarangs = new ArrayList<TBarang>();
		List<TBarang> addedBarangs = util.getTsFromRequest(data);
		for (TBarang barang : addedBarangs) {
			returnBarangs.add(barangDAO.insert(barang));
		}
		return returnBarangs;
	}

	// update barang
	// @param data - json data from request
	@Transactional
	public List<TBarang> update(Object data) {

		List<TBarang> returnBarangs = new ArrayList<TBarang>();

		List<TBarang> updatedBarangs = util.getTsFromRequest(data);

		for (TBarang barang : updatedBarangs) {
			returnBarangs.add(barangDAO.insert(barang));
		}

		return returnBarangs;
	}

	// delete
	// @param data - json data from request
	@Transactional
	public void delete(Object data) {

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			List<Long> deleteBarangs = util.getListIdFromJSON(data);

			for (Long id : deleteBarangs) {
				barangDAO.remove(id);
			}

		} else { // it is only one object - cast to object/bean

			Integer id = Integer.parseInt(data.toString());

			barangDAO.remove(id);
		}
	}

	// DI
	@Autowired
	public void setBarangDAO(BarangDAOImpl barangDAO) {
		this.barangDAO = barangDAO;
	}

	@Autowired
	public void setUtil(JsonUtil<TBarang> util) {
		this.util = util;
		this.util.setT(TBarang.class);
	}
}
