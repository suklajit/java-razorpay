package co.nz.csoft.razorpay.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class RazorPayError {

	    private String code;
	    private String description;
	    private String source;
	    private String step;
	    private String reason;
	    private Metadata metadata;
	    private String field;
	    
	    
	    public static class Metadata{}


		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getSource() {
			return source;
		}


		public void setSource(String source) {
			this.source = source;
		}


		public String getStep() {
			return step;
		}


		public void setStep(String step) {
			this.step = step;
		}


		public String getReason() {
			return reason;
		}


		public void setReason(String reason) {
			this.reason = reason;
		}


		public Metadata getMetadata() {
			return metadata;
		}


		public void setMetadata(Metadata metadata) {
			this.metadata = metadata;
		}


		public String getField() {
			return field;
		}


		public void setField(String field) {
			this.field = field;
		}
	    
	    
	    
}
