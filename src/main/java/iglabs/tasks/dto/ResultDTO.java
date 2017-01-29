package iglabs.tasks.dto;

public class ResultDTO<T> {
	private boolean success;
	private String message;
	private T data;
	
	
	public static <T> ResultDTO<T> success() {
		return ResultDTO.success(null);
	}
	
	public static <T> ResultDTO<T> success(T data) {		
		return new ResultDTO<T>(true, null, data);
	}
	
	public static <T> ResultDTO<T> error(String message) {
		return ResultDTO.error(message, null);
	}
	
	public static <T> ResultDTO<T> error(String message, T data) { 
		return new ResultDTO<T>(false, message, data);
	}
	
	
	public ResultDTO() {
	}
	
	public ResultDTO(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
