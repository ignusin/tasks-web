package iglabs.tasks.dozer;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import iglabs.tasks.dto.ProjectDTO;
import iglabs.tasks.entities.Project;

public class ProjectDTOMapping extends BeanMappingBuilder {
	@Override
	protected void configure() {
		mapping(
			ProjectDTO.class,
			Project.class,
			TypeMappingOptions.mapNull(),
			TypeMappingOptions.mapEmptyString()
		)
		.fields("id", "id")
		.fields("name", "name");
	}
}
