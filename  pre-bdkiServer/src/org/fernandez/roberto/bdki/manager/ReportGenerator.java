package org.fernandez.roberto.bdki.manager;

import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class ReportGenerator {
	public static byte[] getReport(String _filename, 
	        Connection _connection, Map _map) {
	        byte[] report = null;
	        try {
	            JasperReport jasperReport = 
	                JasperCompileManager.compileReport(
	                _filename);
	            JasperPrint jasperPrint = 
	                JasperFillManager.fillReport(jasperReport, 
	                _map, _connection);
	            report = 
	                JasperExportManager.exportReportToPdf(   
	                jasperPrint);
	        } catch (Exception ex) {
	            System.out.println("ex :" + ex.getMessage());
	        }
	        return (report);
	    }

}
