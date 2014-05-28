package br.com.caelum.vraptor.jasperreports.formats;

import javax.enterprise.context.ApplicationScoped;

import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterConfiguration;
import net.sf.jasperreports.export.ReportExportConfiguration;
import net.sf.jasperreports.export.SimpleXlsExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

/**
 * @author William Pivotto
 */

@ApplicationScoped
public class Xls extends AbstractExporter {
	
	public String getContentType() {
		return "application/vnd.ms-excel";
	}

	public String getExtension() {
		return "xls";
	}

	@SuppressWarnings("rawtypes")
	public Exporter setup() {
		return new JRXlsExporter();  
	}

	public ReportExportConfiguration getReportConfiguration() {
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.setOnePagePerSheet(true);
		return configuration;
	}

	public ExporterConfiguration getExporterConfiguration() {
		return new SimpleXlsExporterConfiguration();
	}

}
