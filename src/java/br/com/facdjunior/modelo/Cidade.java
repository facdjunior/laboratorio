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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade {

	@Id
	private Integer codigo;
	private String nome;
	@ManyToOne
	private UF uf;
        private Integer CodIBGE;
	public Cidade() {	}
	public Cidade(Integer codigo, String nome, UF uf) {
		this.codigo = codigo;
		this.nome = nome;
		this.uf = uf;
	}

    public Integer getCodIBGE() {
        return CodIBGE;
    }

    public void setCodIBGE(Integer CodIBGE) {
        this.CodIBGE = CodIBGE;
    }
        
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cidade [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (uf != null ? "uf=" + uf : "") + "]";
	}
	
}
