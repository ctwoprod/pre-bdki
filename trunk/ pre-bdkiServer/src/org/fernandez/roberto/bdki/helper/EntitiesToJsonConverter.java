package org.fernandez.roberto.bdki.helper;

import java.util.ArrayList;
import java.util.List;

import org.fernandez.roberto.bdki.entities.TBarang;
import org.fernandez.roberto.bdki.model.json.BarangJson;
import org.springframework.stereotype.Component;

@Component
public class EntitiesToJsonConverter {
	public static List<BarangJson> convertTBrangToBarangJson(List<TBarang> listTBarangs){
		List<BarangJson> listBarangJsons = new ArrayList<BarangJson>();
		for(TBarang tBarang:listTBarangs){
			BarangJson barangJson = new BarangJson();
			barangJson.setCode_barang(tBarang.getCodeBarang());
			barangJson.setName(tBarang.getNama());
			barangJson.setDescription(tBarang.getDescription());
			barangJson.setVendor(tBarang.getVendor().getName());
			listBarangJsons.add(barangJson);
		}
		return listBarangJsons;
	}
}	
