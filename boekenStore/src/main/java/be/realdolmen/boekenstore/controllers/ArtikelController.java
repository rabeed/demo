package be.realdolmen.boekenstore.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.realdolmen.boekenstore.domain.Artikel;
import be.realdolmen.boekenstore.service.ArtikelService;

@Named
@RequestScoped
public class ArtikelController {

	Logger Logger = LoggerFactory.getLogger(getClass());

	@EJB
	private ArtikelService artikelService;

	private List<Artikel> artikelenList;

	@PostConstruct
	public void init() {
		artikelenList = artikelService.findAll();
	}

	public List<Artikel> getArtikelenList() {
		return artikelenList;
	}

	public void setArtikelenList(List<Artikel> artikelenList) {
		this.artikelenList = artikelenList;
	}

}
