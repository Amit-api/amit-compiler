package com.amit.api.compiler.model.tools;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.amit.api.compiler.model.TypeCommonComposite;

public class ChildrenFinderTest {

	@Test
	public void testGetChildren() {
		TypeCommonComposite v1 = new TypeCommonComposite( "t", "1", null );
			v1.setBaseTypeName( "7" );
		TypeCommonComposite v2 = new TypeCommonComposite( "t", "2", null );
			v2.setBaseTypeName( "1" );
		TypeCommonComposite v3 = new TypeCommonComposite( "t", "3", null );
			v3.setBaseTypeName( "1" );
		TypeCommonComposite v4 = new TypeCommonComposite( "t", "4", null );
			v4.setBaseTypeName( "2" );
		TypeCommonComposite v5 = new TypeCommonComposite( "t", "5", null );
			v5.setBaseTypeName( "2" );
		TypeCommonComposite v6 = new TypeCommonComposite( "t", "6", null );
			v6.setBaseTypeName( "3" );
		TypeCommonComposite v7 = new TypeCommonComposite( "t", "7", null );
		TypeCommonComposite v8 = new TypeCommonComposite( "t", "8", null );
			v8.setBaseTypeName( "7" );
		TypeCommonComposite v9 = new TypeCommonComposite( "t", "9", null );
		TypeCommonComposite v10 = new TypeCommonComposite( "t", "10", null );
			v10.setBaseTypeName( "9" );
			
		List<TypeCommonComposite> list = Arrays.asList( v1, v2, v3, v4, v5, v6, v7, v8, v9, v10 );
		
		
		ChildrenFinder find = new ChildrenFinder( list );
		
		assertEquals( new HashSet<String>(Arrays.asList("2","3","6","4","5" ) ), 
				find.getAllChildren().get( "1" ) );

		assertEquals( new HashSet<String>(Arrays.asList("4","5" ) ), 
				find.getAllChildren().get( "2" ) );

		assertEquals( new HashSet<String>(Arrays.asList("6" ) ), 
				find.getAllChildren().get( "3" ) );

		assertNull( find.getAllChildren().get( "4" ) );
		assertNull( find.getAllChildren().get( "5" ) );
		assertNull( find.getAllChildren().get( "6" ) );

		assertEquals( new HashSet<String>(Arrays.asList("1","2","3","6","4","5", "8" ) ), 
				find.getAllChildren().get( "7" ) );
		
		assertNull( find.getAllChildren().get( "8" ) );
		
		assertEquals( new HashSet<String>(Arrays.asList("10" ) ), 
				find.getAllChildren().get( "9" ) );

		assertNull( find.getAllChildren().get( "10" ) );
	}
}