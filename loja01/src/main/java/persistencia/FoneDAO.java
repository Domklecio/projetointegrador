package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.Fone;

public class FoneDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void inserir(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(fone);
		t.commit();
		sessao.close();
	}

	public static void alterar(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(fone);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(fone);
		t.commit();
		sessao.close();
	}
	
	public static List<Fone> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from Fone order by fon_nome");
		} else {
			consulta = sessao.createQuery("from Fone "
					+ "where fon_nome like :parametro order by fon_nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List<Fone> lista = consulta.list();
		sessao.close();
		return lista;
	}

}
