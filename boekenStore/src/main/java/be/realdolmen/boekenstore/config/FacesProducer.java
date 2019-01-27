package be.realdolmen.boekenstore.config;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesProducer {


	
	@Produces
	@RequestScoped
	public FacesContext context()
	{
		return FacesContext.getCurrentInstance();
	}
}
