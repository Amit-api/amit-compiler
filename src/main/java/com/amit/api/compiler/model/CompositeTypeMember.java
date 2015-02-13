package com.amit.api.compiler.model;

public class CompositeTypeMember extends ProjectElement {
	private String type;
	private boolean isArray = false;

	protected CompositeTypeMember( String type, String name, boolean isArray, Context context ) {
		super( name, context );
		
		if( type == null || type.isEmpty() ) {
			throw new IllegalArgumentException( "type must be not null or empty" );
		}
		
		this.type = type;
		this.isArray = isArray;
	}
	
	/**
	 * returns the item type
	 * @return
	 */
	public String getType() {
		return type;
	}	
	
	public boolean isArray() {
		return isArray;
	}
}
