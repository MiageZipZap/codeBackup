package fr.esiag.isies.pds.businessRules.emergency.sorting;

import org.junit.Test;

import junit.framework.TestCase;

import fr.esiag.isies.pds.model.emergency.sort.Sorting;

public class SortBusinessRulesTest extends TestCase{

	public void testVerify_0(){
		SortingBusinessRules sbr=new SortingBusinessRules();
		
		Sorting sorting=new Sorting();
		sorting.setSortingcategory("InvalidCategory");		
		assertFalse(sbr.verify(sorting));

	}

	public void testVerify_1(){
		SortingBusinessRules sbr=new SortingBusinessRules();
		
		Sorting sorting=new Sorting();
		sorting.setSortingcategory("Tri1");		
		assertTrue(sbr.verify(sorting));

	}
	public void testVerify_2(){
		SortingBusinessRules sbr=new SortingBusinessRules();
		
		Sorting sorting=new Sorting();
		sorting.setSortingcategory("Tri2");		
		assertTrue(sbr.verify(sorting));

	}
	
	public void testVerify_3(){
		SortingBusinessRules sbr=new SortingBusinessRules();
		
		Sorting sorting=new Sorting();
		sorting.setSortingcategory("Tri3");		
		assertTrue(sbr.verify(sorting));

	}
	
	public void testVerify_4(){
		SortingBusinessRules sbr=new SortingBusinessRules();
		
		Sorting sorting=new Sorting();
		sorting.setSortingcategory("Tri4");		
		assertTrue(sbr.verify(sorting));

	}

	public void testVerify_5(){
		SortingBusinessRules sbr=new SortingBusinessRules();
		
		Sorting sorting=new Sorting();
		sorting.setSortingcategory("Tri5");		
		assertTrue(sbr.verify(sorting));

	}
}
