package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import servico.ArtistaServico;
import servico.FilmeServico;
import servico.ParticipacaoServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Artista a1 = new Artista(null, "Wagner Moura", "BR", new BigDecimal("200000.00"), sdf.parse("20/10/1976"));
			Artista a2 = new Artista(null, "Gl�ria Pires", "BR", new BigDecimal("500000.00"), sdf.parse("13/04/1969"));

			Filme f1 = new Filme(null, "Tropa de Elite", 121, 2009);
			
			Participacao p1 = new Participacao(null, "Capit�o Nascimento", new BigDecimal("10000.00"), f1, a1);
			Participacao p2 = new Participacao(null, "Dona Maria", new BigDecimal("50000.00"), f1, a2);
		
			ArtistaServico as = new ArtistaServico();
			FilmeServico fs = new FilmeServico();
			ParticipacaoServico ps = new ParticipacaoServico();
			
			as.inserirAtualizar(a1);
			as.inserirAtualizar(a2);

			fs.inserirAtualizar(f1);
			
			ps.inserirAtualizar(p1);
			ps.inserirAtualizar(p2);
			
			response.getWriter().append("Fim");
		
		}
		catch (ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
