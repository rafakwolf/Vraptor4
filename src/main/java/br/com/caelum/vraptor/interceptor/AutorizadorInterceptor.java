package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AfterCall;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.model.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {

	@Inject private UsuarioLogado usuarioLogado;
	@Inject private Result result;
	@Inject private ControllerMethod controllerMethod;
	
	@Accepts
	public boolean accepts(){
		return !controllerMethod.containsAnnotation(Public.class);
		
	}
	
	@AroundCall
	public void intercepta(SimpleInterceptorStack stack){
		if(usuarioLogado.getUsuario()==null){
			result.redirectTo(LoginController.class).formulario();
			return;
		}
		
		stack.next();
	}
	
	@BeforeCall
	public void before(){
		
	}
	
	@AfterCall
	public void after(){
		
	}
}
