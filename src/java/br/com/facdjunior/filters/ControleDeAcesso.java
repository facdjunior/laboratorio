/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.filters;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francisco Junior 03/07/2015
 */ /*
@WebFilter(servletNames = {"Faces Servlet"})
public class ControleDeAcesso implements Filter{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException{
        
        HttpServletRequest req=(HttpServletRequest)request;
        HttpSession session = req.getSession();
    if (session.getAttribute("usuario")!= null|| req.getRequestURI().endsWith("Login.xhtml")){
        chain.doFilter(request, response);
    }else{
        HttpServletResponse res = (HttpServletResponse)response;
        res.sendRedirect("Login.xhtml");
    }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        
    }
   @Override
public void destroy(){
}
}*/