package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	//@Inject private Result result;
	private final Result result;
	private final ProdutoDao produtoDao;
	private final Validator validator;
	private final Mailer mailer;
	
	
	
	
	
	@Inject
	public ProdutoController(Result result, ProdutoDao produtoDao, Validator validator, Mailer mailer) {
		this.result = result;
		this.produtoDao = produtoDao;
		this.validator = validator;
		this.mailer = mailer;
	}
	
	
	
	@Deprecated
	public ProdutoController() {
		this(null, null, null, null);
	}




	@Get("/")
	public void inicio() {
		// TODO Auto-generated method stub

	}
	@Get("/produto/lista")
	public void lista() {
		result.include("produtoList", produtoDao.lista());
	}
	
	@Get("/produto/listaXML")
	public void listaXML() {
		result.use(Results.xml()).from(produtoDao.lista()).serialize();
	}
	
	@Get("/produto/listaJSON")
	public void listaJSON() {
		result.use(Results.json()).from(produtoDao.lista()).serialize();
	}
	
	
	@Get("/produto/sobre")
	public void sobre() {
		
	}
	
	@Get("/produto/formulario")
	public void formulario() {
	}
	
	@Post("/produto/adiciona")
	public void adiciona(@Valid Produto produto) {
		//validator.check(produto.getQuantidade()>0, new SimpleMessage("produto.quantidade", "Não pode ser negativo!"));
		//validator.check(produto.getQuantidade()>0, new I18nMessage("produto.quantidade","quantidade.negativa"));
		
		validator.onErrorForwardTo(this).formulario();
		
		produtoDao.adiciona(produto);
		result.include("mensagem", "Produto adicionado com sucesso!");
		result.redirectTo(this).lista();
		
	}
	
	@Get("/produto/remove")
	public void remove(Produto produto) {
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		em.getTransaction().begin();
		dao.remove(produto);
		em.getTransaction().commit();
	}
	
	@Get("/produto/enviaPedidoDeNovosItens")
	public void enviaPedidoDeNovosItens(Produto produto) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setSubject("Precisamos de mais estoque");
		email.setMsg("O produto "+produto.getNome()+" está em falta no estoque!");
		email.addTo("saulocn@gmail.com");
		mailer.send(email);
		result.redirectTo(this).lista();
	}
	
	
	
	
}
