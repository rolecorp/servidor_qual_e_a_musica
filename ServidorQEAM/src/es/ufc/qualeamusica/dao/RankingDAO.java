package es.ufc.qualeamusica.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import es.ufc.qualeamusica.model.Ranking;
import es.ufc.qualeamusica.persistencia.CriarTabelas;


public class RankingDAO {
	
public ArrayList<Ranking> listarTodos(){
		
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
			
		Criteria criteria = sessao.createCriteria(Ranking.class);
		ArrayList<Ranking> rankingGeral =  (ArrayList<Ranking>) criteria.list();
		
		trasaction.commit();
		sessao.close();
		
		return rankingGeral;
	}
	
	public void deletar(Ranking rankingGeral){
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
		
		Ranking reservaCarregada = (Ranking) sessao.load(Ranking.class, rankingGeral.getId());
		
		sessao.delete(reservaCarregada);
		
		trasaction.commit();
		sessao.close();
	}
	
	public void cadastrar(Ranking rankingGeral){
		
		Session sessao = CriarTabelas.prepararSessao();
		try{
			Transaction trasaction = sessao.beginTransaction();
			sessao.save(rankingGeral);
			
			trasaction.commit();
			
		}catch (HibernateException e) {
			System.out.println("Excecao Hibernate: " + e.getMessage() + " :: "
					+ e.toString());
		}
		finally{
			sessao.close();
		}
	}
	
	public void atualizar(Ranking novoRanking){
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
		
		Ranking rankingCarregada = (Ranking) sessao.load(Ranking.class, novoRanking.getId());
				
		rankingCarregada = novoRanking;
		
		sessao.update(rankingCarregada);
		
		trasaction.commit();
		sessao.close();
	}
	
	public Ranking buscarRankingPor(Long id){
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
			
		Criteria criteria = sessao.createCriteria(Ranking.class);
		criteria.add(Restrictions.eq("id", id));
		
		Ranking rankingGeral =  (Ranking) criteria.uniqueResult();
		
		trasaction.commit();
		sessao.close();
		
		return rankingGeral;
	}
}
