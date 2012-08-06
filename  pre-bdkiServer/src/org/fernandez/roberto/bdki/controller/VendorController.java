package org.fernandez.roberto.bdki.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fernandez.roberto.bdki.entities.TVendor;
import org.fernandez.roberto.bdki.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VendorController {
	private VendorService vendorService;

	@RequestMapping(value = "/vendor/getVendor.do")
	public @ResponseBody
	Map<String, ? extends Object> view() throws Exception {
		try {

			List<TVendor> vendors = vendorService.getVendorList();
			return getMap(vendors);

		} catch (Exception e) {
			return getModelMapError("Error retrieving Vendors from database.");
		}
	}

	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param vendors
	 * @return
	 */
	private Map<String, Object> getMap(List<TVendor> vendors) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("listVendor", vendors);

		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView in case of exception
	 * 
	 * @param msg
	 *            message
	 * @return
	 */
	private Map<String, Object> getModelMapError(String msg) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	}

	@Autowired
	public void setInventoryService(VendorService vendorService) {
		this.vendorService = vendorService;
	}
}
