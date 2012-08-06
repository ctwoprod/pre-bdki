package org.fernandez.roberto.bdki.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping(value = "/test/buatChart.do")
	public @ResponseBody
	Map<String, ? extends Object> view() throws Exception {

		try {
			List<Map<String, Object>> listIsi = new ArrayList<Map<String,Object>>();
			Map<String, Object> isi = new HashMap<String, Object>(4);
			isi.put("no",1 );
			isi.put("bulan","jan" );
			isi.put("beli",10 );
			isi.put("sewa",10 );
			listIsi.add(isi);
			Map<String, Object> isi2 = new HashMap<String, Object>(4);
			isi2.put("no",2 );
			isi2.put("bulan","feb" );
			isi2.put("beli",5 );
			isi2.put("sewa",50 );
			listIsi.add(isi2);
			Map<String, Object> isi3 = new HashMap<String, Object>(4);
			isi3.put("no",3 );
			isi3.put("bulan","mar" );
			isi3.put("beli",10 );
			isi3.put("sewa",30 );
			listIsi.add(isi3);
			Map<String, Object> isi4 = new HashMap<String, Object>(4);
			isi4.put("no",4 );
			isi4.put("bulan","apr" );
			isi4.put("beli",20 );
			isi4.put("sewa",15 );
			listIsi.add(isi4);			
			Map<String, Object> isi5 = new HashMap<String, Object>(4);
			isi5.put("no",5 );
			isi5.put("bulan","mei" );
			isi5.put("beli",60 );
			isi5.put("sewa",70 );
			listIsi.add(isi5);			
			Map<String, Object> isi6 = new HashMap<String, Object>(4);
			isi6.put("no",6 );
			isi6.put("bulan","jun" );
			isi6.put("beli",40 );
			isi6.put("sewa",80 );
			listIsi.add(isi6);
			
			Map<String, Object> modelMap = new HashMap<String, Object>(1);
			modelMap.put("transaksi", listIsi);
			return modelMap;

		} catch (Exception e) {

			return getModelMapError("Error retrieving Barangs from database.");
		}
	}
	@RequestMapping(value = "/test/login.do")
	public @ResponseBody
	Map<String, ? extends Object> view2(@RequestParam String username, @RequestParam String password) throws Exception {
		System.out.println("username = "+username);
		System.out.println("password = "+password);
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(1);
			modelMap.put("success", false);
			return modelMap;

		} catch (Exception e) {
			return getModelMapError("Error retrieving Barangs from database.");
		}
	}
	@RequestMapping(value = "/test/testPost.do")
	public @ResponseBody
	Map<String, ? extends Object> testPost(@RequestParam String param1, @RequestParam String param2, 
			@RequestParam String param3) throws Exception {
		System.out.println("param1 = "+param1);
		System.out.println("param2 = "+param2);
		System.out.println("param3 = "+param3);
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(1);
			modelMap.put("success", false);
			return modelMap;

		} catch (Exception e) {
			return getModelMapError("Error test Post from database.");
		}
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
}
