package br.com.facdjunior.bean.converter;

import br.com.facdjunior.modelo.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.facdjunior.modelo.UF;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@FacesConverter("ufConverter")
public class UFConverter implements Converter {

        
	private EntityManager entityManager;
        private EntityManagerFactory factory = Persistence.createEntityManagerFactory("SysLab_PU");
        private EntityManager em = factory.createEntityManager();
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return em.find(UF.class, Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(((UF) value).getCodigo());
	}

}
