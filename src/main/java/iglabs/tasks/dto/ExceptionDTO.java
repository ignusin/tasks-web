package iglabs.tasks.dto;

public class ExceptionDTO {
	private String message;
	private Exception data;
	
		
	public ExceptionDTO() {
	}
	
	public ExceptionDTO(String message, Exception data) {
		this.message = message;
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Exception getData() {
		return data;
	}
	
	public void setData(Exception data) {
		this.data = data;
	}
}
