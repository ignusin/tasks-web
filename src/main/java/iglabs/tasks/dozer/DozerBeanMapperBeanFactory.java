package iglabs.tasks.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class DozerBeanMapperBeanFactory implements FactoryBean<Mapper>, InitializingBean {
	private DozerBeanMapper mapper;
	
	@Override
	public void afterPropertiesSet() {
		mapper = new DozerBeanMapper();
		mapper.addMapping(new ProjectDTOMapping());
		mapper.addMapping(new UserDTOMapping());
	}
	
	@Override
	public Mapper getObject() {
		return mapper;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Class<Mapper> getObjectType() {
		return Mapper.class;
	}
}
