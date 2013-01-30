package es.ufc.qualeamusica.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.ufc.qualeamusica.dao.RankingGeralDAO;
import es.ufc.qualeamusica.model.RankingGeral;
import es.ufc.qualeamusica.webservice.DataSerializer;


public class ServletRequisicaoGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletRequisicaoGet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamou o Servlet");
		String nome = request.getParameter("nome");
		String pontuacao = request.getParameter("pontuacao");
		double pontuacaoDouble = Double.parseDouble(pontuacao);
		
		RankingGeral ranking = new RankingGeral();
		ranking.setNomeUsuario(nome);
		ranking.setPontuacao(pontuacaoDouble);
		
		RankingGeralDAO rgdao = new RankingGeralDAO();
		rgdao.cadastrar(ranking);
		System.out.println("CADASTROU");
		PrintWriter out = response.getWriter();
        out.println("Pontuação enviada com sucesso!!!");
		
	}

			
}
