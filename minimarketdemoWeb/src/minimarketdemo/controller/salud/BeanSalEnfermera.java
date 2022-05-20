package minimarketdemo.controller.salud;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.SalCarnet;
import minimarketdemo.model.salud.managers.ManagerSalud;

@Named
@SessionScoped
public class BeanSalEnfermera implements Serializable {
	@EJB
	private ManagerSalud mSalud;
	private List<SalCarnet> listaCarnet;

	public BeanSalEnfermera() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		this.listaCarnet = mSalud.findAllCarnet();
	}

	public List<SalCarnet> getListaCarnet() {
		return listaCarnet;
	}

	public void setListaCarnet(List<SalCarnet> listaCarnet) {
		this.listaCarnet = listaCarnet;
	}

}
