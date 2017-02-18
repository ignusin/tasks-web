package iglabs.tasks.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="root_tasks")
public class RootTask extends IdentityEntity {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="task_id")
	private Task task;

	public RootTask() {
	}
	
	public RootTask(Project project, Task task) {
		this.project = project;
		this.task = task;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
