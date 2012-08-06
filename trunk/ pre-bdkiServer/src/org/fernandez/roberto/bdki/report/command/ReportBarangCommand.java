package org.fernandez.roberto.bdki.report.command;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.fernandez.roberto.bdki.dao.impl.BarangDAOImpl;
import org.fernandez.roberto.bdki.entities.TBarang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportBarangCommand {
		private BarangDAOImpl barangDAO;
	@Autowired
	public void setBarangDAO(BarangDAOImpl barangDAO) {
		this.barangDAO = barangDAO;
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response, String location)
			throws ServletException, IOException {
		response.setContentType("application/pdf");

        // set input and output stream
        ServletOutputStream servletOutputStream=null;
		try {
			servletOutputStream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis;
        BufferedInputStream bufferedInputStream;

        try {
            // get report location
            

            // get report
            fis = new FileInputStream(location);
            bufferedInputStream = new BufferedInputStream(fis);

            // fetch data from database
            
            List<TBarang> masters = barangDAO.findAll(null);


            // fill it
            JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(masters);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), jrbcds);

            // export to pdf
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

            response.setContentLength(baos.size());
            baos.writeTo(servletOutputStream);

            // close it
            fis.close();
            bufferedInputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            servletOutputStream.flush();
            servletOutputStream.close();
            baos.close();
        }

	
	}
}
