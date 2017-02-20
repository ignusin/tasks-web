package iglabs.tasks.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task extends IdentityEntity {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id", nullable=true)
	private Task parent;
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id", nullable=false)
	private User owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assigned_to_id", nullable=false)
	private User assignedTo;
	
	@Column(name="finished", nullable=false)
	private boolean finished;
	
	@Column(name="created_at", nullable=false)
	private Timestamp createdAt;
	
	@Column(name="due_at", nullable=true)
	private Timestamp dueAt;
	
	@Column(name="finished_at", nullable=true)
	private Timestamp finishedAt;

	public Task getParent() {
		return parent;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getDueAt() {
		return dueAt;
	}
	
	public void setDueAt(Timestamp dueAt) {
		this.dueAt = dueAt;
	}
	
	public Timestamp getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Timestamp finishedAt) {
		this.finishedAt = finishedAt;
	}
}
