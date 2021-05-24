package br.com.zup.livraria.livraria.notation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ItExistsValidator implements ConstraintValidator<ItExist, Object>{

	private String domainAttribute;
	private Class<?> klass;
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public void initialize(ItExist params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		System.out.println("gustavo -> " + list.isEmpty());
		Assert.state(list.size() <= 1 , "Foi encontrado "+query.getResultList()+" da tabela "+klass.getName());
		
		return !list.isEmpty();
	}

}
