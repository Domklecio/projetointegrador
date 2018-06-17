package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Fone;
import persistencia.FoneDAO;

@ManagedBean
@SessionScoped
public class FoneCtrl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Fone fone;
	
	public Fone getFone() {
		if(fone == null) {
			fone = new Fone();
		}
		return fone;
	}
	
	public void setFone(Fone fone) {
		this.fone = fone;
	}
	
	public List<Fone> getListagem() {
		return FoneDAO.listagem("");
	}
	
	public String actionGravar(){
		if(fone.getId() == 0) {
			FoneDAO.inserir(fone);
			return actionInserir();
		} else {
			FoneDAO.alterar(fone);
			return "lista_fone";
		}
	}
	public String actionInserir() {
		fone = new Fone();
		return "form_fone";
	}
	
	public String actionExcluir(Fone f){
		FoneDAO.excluir(f);
		return "lista_fone";
	}
	
	public String actionAlterar(Fone f){
		this.fone = f;
		return "form_fone";
	}
}
