package org.fernandez.roberto.bdki.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import org.fernandez.roberto.bdki.manager.DBManager;
import org.fernandez.roberto.bdki.manager.ReportGenerator;

/**
 * Servlet implementation class PrintServlet
 */
@WebServlet("/PrintServlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	/**
	 * Default constructor.
	 */
	public PrintServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			connection = DBManager.getConnection("localhost", "pre_bdki",
					"root", "adminmysql");
		} catch (Exception ex) {
			System.out.println("ex :" + ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get get get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.addHeader("Content-Disposition", "attachment");
//		response.setContentType("application/pdf");
//		ServletOutputStream sos = response.getOutputStream();
//
//		String reportType = request.getParameter("reportType");
//
//		if ((reportType != null) && (reportType.equalsIgnoreCase("rptBarang"))) {
//			sos.write(ReportGenerator.getReport(getServletContext()
//					.getRealPath("/WEB-INF/report/rptBarang.jrxml"),
//					connection, null));
//		}
		byte[] byteStream;
		try {
			byteStream = JasperRunManager.runReportToPdf(
					getServletContext().getRealPath("/WEB-INF/report/rptBarang.jasper")
							, null, connection);

			OutputStream outStream = response.getOutputStream();
			response.setHeader("Content-Disposition",
					"attachment, filename=myReport.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(byteStream.length);
			outStream.write(byteStream, 0, byteStream.length);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			connection.close();
		} catch (Exception ex) {
			System.out.println("ex :" + ex.getMessage());
		}

	}

}
