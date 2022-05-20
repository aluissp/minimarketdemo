package minimarketdemo.model.salud.managers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import minimarketdemo.model.core.entities.SalCarnet;

/**
 * Session Bean implementation class ManagerSalud
 */
@Stateless
@LocalBean
public class ManagerSalud {

	@PersistenceContext
	private EntityManager eManager;

	/**
	 * Default constructor.
	 */
	public ManagerSalud() {
		// TODO Auto-generated constructor stub
	}

//    metodos para la secretaria
	public void insertarCarnet(SalCarnet carnet) {
		carnet.setVerificado(false);
		eManager.persist(carnet);
	}

	public List<SalCarnet> findAllCarnet() {
		return eManager.createNamedQuery("SalCarnet.findAll", SalCarnet.class).getResultList();
	}

//    metodos para enfermera
	public void validadCarnet(SalCarnet carnet) {
		carnet.setVerificado(true);
		eManager.merge(carnet); 
	}

}
