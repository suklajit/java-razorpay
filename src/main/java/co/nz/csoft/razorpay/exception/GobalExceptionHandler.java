package co.nz.csoft.razorpay.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex) {
		String errorMessage = ex.getMessage();
		ApiResponse response = new ApiResponse(errorMessage, "unsuccessfull");
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<?> noDataFoundException(NoDataFoundException ex) {
		String errorMessage = ex.getMessage();
		ApiResponse response = new ApiResponse(errorMessage, "unsuccessfull");
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errorResponses = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errorResponses.put(fieldName, errorMessage);
		});
		return new ResponseEntity<Map<String, String>>(errorResponses, HttpStatus.BAD_REQUEST);
	}
	
	
	
	public ResponseEntity<?> invalidAmount(){
		
		return null;
	}
	
	
	@ExceptionHandler(RazorpayOrderIdNotFoundException.class)
	public ResponseEntity<?> orederIdNotFound(RazorpayOrderIdNotFoundException exception){
		RazorPayError razorPayError = new RazorPayError();
		razorPayError.setCode("BAD_REQUEST_ERROR");
		razorPayError.setDescription("The id provided does not exist....! ");
		razorPayError.setSource("business");
		razorPayError.setStep("payment_initiation");
		razorPayError.setReason("input_validation_failed");
//		razorPayError.setMetadata(new Metadata());
		return new ResponseEntity<>(razorPayError,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
