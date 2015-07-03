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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francisco Junior 01/07/2015
 */
@WebFilter(servletNames = {"Faces Servlet"})
public class JPAFilter implements Filter{
    
    private EntityManagerFactory factory;
    
    @Override
    public void init (FilterConfig filterConfig) throws ServletException{
        this.factory = Persistence.createEntityManagerFactory("SysLab_PU");
    }
    @Override
    public void destroy(){
        this.factory.close();
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException{
        
        //CHEGADA das requisições Salvar/Alterar / excluir consultar
        EntityManager manager = this.factory.createEntityManager();
        request.setAttribute("EntityManager", manager);
        manager.getTransaction().begin();
        //CHEGADA das requisições Salvar/Alterar / excluir consultar
        // Faces Servlet
        chain.doFilter(request, response);
        // Faces Servlet
        //Saida
        try{
        manager.getTransaction().commit();
        
    }catch(Exception e){
        manager.getTransaction().rollback();
    }finally{
            manager.close();
        }
    }
        //Saida
}
