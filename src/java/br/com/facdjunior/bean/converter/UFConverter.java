package br.com.facdjunior.bean.converter;

import br.com.facdjunior.controle.UFBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.facdjunior.modelo.UF;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.ConversionException;


@FacesConverter("ufConverter")
public class UFConverter implements Converter {

	
	private EntityManager entityManager;
        
        public static List<UF> UFBean = (List<UF>) new UFBean().getUfss();
    
        
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, 
                String submittedValue) {
            if(submittedValue.trim().equals("")){
                return null;
        } else{
                try{
                    String uf= submittedValue;
                    for(UF l : UFBean){
                    if(l.getSigla().equals(uf)){
                        return l;
                    }
                }
                }catch(NumberFormatException exception){
                    throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na Conversion", "UF invalido"));
                }
            }
            return null;
        }
	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
	if(value !=null && !"".equals("")){
            return "";
        }else{
            return String.valueOf(((UFBean) value).getUfss());
        }
            
}
        
}
