/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.modelo;

/**
 *
 * @author Francisco Junior 03/07/2015
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UF implements Serializable{
	
	@Id 
        @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String sigla;
	private String nome;
        private Integer codIBGE;

   
	public UF() { }
	public UF(Integer codigo, String sigla, String nome) {
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
         public Integer getCodIBGE() {
        return codIBGE;
    }

        public void setCodIBGE(Integer codIBGE) {
        this.codIBGE = codIBGE;
    }
}
