package iglabs.tasks.dao;

import java.util.List;
import iglabs.tasks.entities.IdentityEntity;

public interface GenericDAO<T extends IdentityEntity> {
	void add(T entity);
	void update(T entity);
	void remove(T entity);
	
	List<T> list();
	T find(int id);
}
