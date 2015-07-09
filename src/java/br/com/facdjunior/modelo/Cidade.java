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
        private Integer uf;
        private Integer CodIBGE;
	
   	
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

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }



 



 
	
	
}
