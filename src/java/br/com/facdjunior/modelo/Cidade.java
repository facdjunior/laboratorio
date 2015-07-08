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

 



 
	
	
}
