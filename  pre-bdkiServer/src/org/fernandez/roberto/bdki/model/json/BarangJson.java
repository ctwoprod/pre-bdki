package org.fernandez.roberto.bdki.model.json;

public class BarangJson {
	private String code_barang;
	private String description;
	private String name;
	private String vendor;
	public BarangJson() {
		super();
	}
	public String getCode_barang() {
		return code_barang;
	}
	public void setCode_barang(String code_barang) {
		this.code_barang = code_barang;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
}
