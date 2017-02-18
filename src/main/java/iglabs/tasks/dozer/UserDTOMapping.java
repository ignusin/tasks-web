package iglabs.tasks.dozer;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import iglabs.tasks.dto.UserDTO;
import iglabs.tasks.entities.User;

public class UserDTOMapping extends BeanMappingBuilder {
	@Override
	protected void configure() {
		mapping(
			UserDTO.class,
			User.class,
			TypeMappingOptions.mapNull(),
			TypeMappingOptions.mapEmptyString()
		);
	}
}
