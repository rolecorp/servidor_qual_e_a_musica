package es.ufc.qualeamusica.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.ufc.qualeamusica.dao.RankingDAO;
import es.ufc.qualeamusica.model.Ranking;
import es.ufc.qualeamusica.webservice.DataSerializer;

public class ServletJSON extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {		
		this.doGet(req, resp);
		
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Processando requisição - Front Controller UM");
		
//		String requestData = processRequest(request);	 /* A String JSOn enviada pelo dispositivo móvel */	
//		System.out.println("Request Data" + requestData);
		
//		RankingGeral rankingGeral = DataSerializer.getInstance().converterParaRankingGeral(requestData);
//		rankingGeral.setIdade(25);
		RankingDAO dao = new RankingDAO();
		List<Ranking> rankingGeral = dao.listarTodos();
		
		String responseData = DataSerializer.getInstance().converterParaJson(rankingGeral);   

		 PrintWriter out = response.getWriter();
		 out.write(responseData);
	}
	
	private String processRequest(HttpServletRequest request) {
		 StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { e.printStackTrace(); }
		  
		  return jb.toString();

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
		processRequest(req, resp);
	
	}



	
}
