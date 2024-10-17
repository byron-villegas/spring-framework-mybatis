package cl.villegas.mybatis.exception;

import javax.servlet.http.HttpServletRequest;
import org.joda.time.DateTime;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = { "cl.villegas.mybatis.controller" })
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private final static Logger logger = Logger.getLogger(RestExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	ApiError handleBadRequest(HttpServletRequest req, Exception ex) {
		logger.error(ex.getStackTrace().toString());
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "400",
				"Ha ocurrido un problema al procesar la peticion", ex.getLocalizedMessage(),
				DateTime.now().toLocalDateTime().toString());
		return apiError;
	}
}