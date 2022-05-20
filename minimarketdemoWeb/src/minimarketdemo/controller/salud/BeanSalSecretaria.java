package minimarketdemo.controller.salud;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.SalCarnet;
import minimarketdemo.model.salud.managers.ManagerSalud;

@Named
@SessionScoped
public class BeanSalSecretaria implements Serializable {
	@EJB
	private ManagerSalud mSalud;
	private SalCarnet carnetNuevo;
	private List<SalCarnet> listaCarnet;

	public BeanSalSecretaria() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		carnetNuevo = new SalCarnet();
		listaCarnet = mSalud.findAllCarnet();
	}

	public void actionListenerInsertarCarnet() {
		mSalud.insertarCarnet(carnetNuevo);
		carnetNuevo = new SalCarnet();
		listaCarnet = mSalud.findAllCarnet();
		JSFUtil.crearMensajeINFO("Carnet guardado.");
	}

	public SalCarnet getCarnetNuevo() {
		return carnetNuevo;
	}

	public void setCarnetNuevo(SalCarnet carnetNuevo) {
		this.carnetNuevo = carnetNuevo;
	}

	public List<SalCarnet> getListaCarnet() {
		return listaCarnet;
	}

	public void setListaCarnet(List<SalCarnet> listaCarnet) {
		this.listaCarnet = listaCarnet;
	}

}
