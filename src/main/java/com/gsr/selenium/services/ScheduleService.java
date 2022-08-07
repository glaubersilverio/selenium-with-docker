package com.gsr.selenium.services;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

	private static Logger LOG = LoggerFactory.getLogger(ScheduleService.class);

	@Autowired
	private WebDriver webDriver;

	@Value("${url.site}")
	private String url;
	
	@Scheduled(cron = "0 */1 * * * *")
	public void run() throws Exception {
		LOG.info("Inicializando aplicação...");
		webDriver.get(url);
		String titulo = webDriver.getTitle();
		String urlCorrente = webDriver.getCurrentUrl();
		webDriver.quit();
		LOG.info("Título da página aberta: {}", titulo);
		LOG.info("URL: {}", urlCorrente);
	}
}