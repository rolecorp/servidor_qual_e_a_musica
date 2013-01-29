package es.ufc.qualeamusica.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import es.ufc.qualeamusica.model.RankingGeral;
import es.ufc.qualeamusica.persistencia.CriarTabelas;


public class RankingGeralDAO {
	
public ArrayList<RankingGeral> listarTodos(){
		
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
			
		Criteria criteria = sessao.createCriteria(RankingGeral.class);
		ArrayList<RankingGeral> rankingGeral =  (ArrayList<RankingGeral>) criteria.list();
		
		trasaction.commit();
		sessao.close();
		
		return rankingGeral;
	}
	
	public void deletar(RankingGeral rankingGeral){
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
		
		RankingGeral reservaCarregada = (RankingGeral) sessao.load(RankingGeral.class, rankingGeral.getId());
		
		sessao.delete(reservaCarregada);
		
		trasaction.commit();
		sessao.close();
	}
	
	public void cadastrar(RankingGeral rankingGeral){
		
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
	
	public void atualizar(RankingGeral novoRanking){
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
		
		RankingGeral rankingCarregada = (RankingGeral) sessao.load(RankingGeral.class, novoRanking.getId());
				
		rankingCarregada = novoRanking;
		
		sessao.update(rankingCarregada);
		
		trasaction.commit();
		sessao.close();
	}
	
	public RankingGeral buscarRankingPor(Long id){
		Session sessao = CriarTabelas.prepararSessao();
		Transaction trasaction = sessao.beginTransaction();
			
		Criteria criteria = sessao.createCriteria(RankingGeral.class);
		criteria.add(Restrictions.eq("id", id));
		
		RankingGeral rankingGeral =  (RankingGeral) criteria.uniqueResult();
		
		trasaction.commit();
		sessao.close();
		
		return rankingGeral;
	}
}
