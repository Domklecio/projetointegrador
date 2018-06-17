package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import beans.Fone;
import beans.Pessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private String pessoalogada;
	private Pessoa listapessoa;

	
	public String getPessoalogada() {
		return pessoalogada;
	}

	public void setPessoalogada(String pessoalogada) {
		this.pessoalogada = pessoalogada;
	}

	public void setListapessoa(Pessoa listapessoa) {
		this.listapessoa = listapessoa;
	}

	public Pessoa getListapessoa() {
		listapessoa = PessoaDAO.retornaUsuario();
		return listapessoa;
	}



	public Pessoa getPessoa() {
		if(pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem("");
	}
	
	public List<Pessoa> getListpessoa() {
		return PessoaDAO.listpessoa("");
	}
	
	
	public String actionGravar(){
		if(pessoa.getId() == 0) {
			PessoaDAO.inserir(pessoa);
			return actionInserir();
		} else {
			PessoaDAO.alterar(pessoa);
			return "index";
		}
	}
	public String actionInserir() {
		pessoa = new Pessoa();
		return "index";
	}
	
	public String actionExcluir(Pessoa p){
		PessoaDAO.excluir(p);
		return "form_pessoa";
	}
	
	public String actionAlterar(Pessoa p){
		this.pessoa = p;
		return "form_pessoa";
	}
	
	public String actionInserirFone() {
		Fone fone = new Fone();
		fone.setPessoa(pessoa);
		pessoa.getFones().add(fone);
		return "index";
	}
	
	
	public String actionExcluirFone(Fone f) {
		PessoaDAO.excluir(f);
		return "form_pessoa";
		
		/*--------------Spring Security--------------*/
		
	}
	public static String getUsuarioLogado() {
		UserDetails user =((UserDetails) SecurityContextHolder .getContext() 
				.getAuthentication().getPrincipal());
		return user.getUsername();
	}
	
	
	
}