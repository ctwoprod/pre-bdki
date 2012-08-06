package org.fernandez.roberto.bdki.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fernandez.roberto.bdki.entities.TBarang;
import org.fernandez.roberto.bdki.helper.EntitiesToJsonConverter;
import org.fernandez.roberto.bdki.model.json.BarangJson;
import org.fernandez.roberto.bdki.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InventoryController {
	private InventoryService inventoryService;
	private EntitiesToJsonConverter entitiesToJsonConverter;
	
	@RequestMapping(value = "/inventory/getBarang.do")
	public @ResponseBody
	Map<String, ? extends Object> view() throws Exception {
		try {

			List<TBarang> barangs = inventoryService.getBarangList();
			List<BarangJson> barangJsons = EntitiesToJsonConverter.convertTBrangToBarangJson(barangs);
			return getMap(barangJsons);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Barangs from database.");
		}
	}
	/**
	 * Generates modelMap to return in the modelAndView
	 * 
	 * @param barangs
	 * @return
	 */
	private Map<String, Object> getMap(List<BarangJson> barangs) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
//		modelMap.put("total", players.size());
		modelMap.put("listBarang", barangs);
//		modelMap.put("success", true);

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
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	@Autowired
	public void setEntitiesToJsonConverter(EntitiesToJsonConverter entitiesToJsonConverter) {
		this.entitiesToJsonConverter= entitiesToJsonConverter;
	}
}
