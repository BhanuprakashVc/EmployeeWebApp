/**
 * 
 */
package com.employee;

/**
 * @author 308040
 *
 */

public class VIEWS {
	
	public enum Operations {
		
		WELCOME("welcome"),
		create("create"),
		read("read"),
		delete("delete"),
		update("update"),
		others("others");
		
	    private final String name;
	
	    /**
	     * Instantiates a new view name.
	     *
	     * @param name the name
	     */
	    private Operations(final String name) {
	        this.name = name;
	    }
	
	    /**
	     * Gets the view name.
	     *
	     * @return the view name
	     */
	    public String getOperations() {
	        return name;
	    }
	}
}