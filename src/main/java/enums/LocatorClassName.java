package enums;

	public enum LocatorClassName {
		

	    LOGIN_LOCATOR_CLASS("LoginPage");
	
	    private final String type;

		LocatorClassName(String type) {
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
