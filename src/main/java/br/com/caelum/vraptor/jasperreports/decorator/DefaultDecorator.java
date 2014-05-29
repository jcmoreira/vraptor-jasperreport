package br.com.caelum.vraptor.jasperreports.decorator;

import java.util.Locale;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import net.sf.jasperreports.engine.JRParameter;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.ReportPathResolver;

@RequestScoped
public class DefaultDecorator implements ReportDecorator {

	@Inject private Locale locale;
	@Inject private ReportPathResolver resolver;
	@Inject private Result result;

	public void decorate(Report report) {
		if(report.getParameters() != null) {
			ReportsResourceBundle bundle = new ReportsResourceBundle(locale, resolver);
			report.addParameter("REPORT_DIR", resolver.getReportsPath());
			report.addParameter("SUBREPORT_DIR", resolver.getSubReportsPath());
			report.addParameter("IMAGES_DIR", resolver.getImagesPath());
			report.addParameter(JRParameter.REPORT_LOCALE, locale);
			report.addParameter(JRParameter.REPORT_RESOURCE_BUNDLE, bundle);
			includeRequestParameters(report);
		}
	}
	
	private void includeRequestParameters(Report report) {
		for(Map.Entry<String, Object> entry : result.included().entrySet()){
			report.addParameter(entry.getKey(), entry.getValue());
		}
	}
	
}