package enums;

	public enum Credentials {
		

	    EMAIL("login.email"),
		PASSWORD("login.password");

	    private final String type;
	
		Credentials(String type) {
	        this.type = type;
	    }
	
	    public String getType() {
	        return type;
	    }
	    @Override
	    public String toString() {
	        return type;
	    }
	}
