package co.nz.csoft.razorpay.exception;

@SuppressWarnings("serial")
public class NoDataFoundException extends RuntimeException{

	private String resourceName;

	public NoDataFoundException(String resourceName) {
		super(String.format("there is no data exist of entity : %s",resourceName));
		this.resourceName = resourceName;
	}

	public NoDataFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
