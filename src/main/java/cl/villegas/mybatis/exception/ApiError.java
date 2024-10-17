package cl.villegas.mybatis.exception;

import org.springframework.http.HttpStatus;

public class ApiError {
	private String timeStamp;
	private String error_code;
	private HttpStatus status;
	private String message;
	private String errors;

	public ApiError(HttpStatus status, String error_code, String message, String errors, String timeStamp) {
		super();
		this.status = status;
		this.error_code = error_code;
		this.message = message;
		this.errors = errors;
		this.timeStamp = timeStamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}