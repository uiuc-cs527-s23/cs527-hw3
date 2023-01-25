package edu.illinois.cs.formal;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.microsoft.z3.Context;

public class IntegerModelTest
{
	@Test
	public void test1(){
		// instantiate default z3 context for contraint solving
		Context ctx = new Context();
		// input matrix: each row denotes a requirement or coverage element, while each column denotes a test
		int[][] instance = { { 1, 0, 1, 0 }, { 0, 1, 0, 0 },{ 1, 0, 0, 0 }, { 1, 0, 1, 1 } };
		// expected reduced test suite, including only the first two tests
		Set<Integer> expected=new HashSet<Integer>(Arrays.asList(1, 2));
		// run the reduction and get the actual reduced test suite
		Set<Integer> reduced=IntegerModel.TestReduction(ctx, instance);
		// check if the reduced test set is as expected
		assertEquals(expected, reduced);
	}
	
	@Test
	public void test2(){
		// instantiate default z3 context for contraint solving
		Context ctx = new Context();
		// input matrix: each row denotes a requirement or coverage element, while each column denotes a test
		int[][] instance = { { 1, 0, 1, 0 }, { 0, 0, 0, 1 },{ 1, 0, 0, 0 }, { 1, 0, 1, 1 } };
		// expected reduced test suite, including only the first and fourth tests
		Set<Integer> expected=new HashSet<Integer>(Arrays.asList(1, 4));
		// run the reduction and get the actual reduced test suite
		Set<Integer> reduced=IntegerModel.TestReduction(ctx, instance);
		// check if the reduced test set is as expected
		assertEquals(expected, reduced);
	}
	
	@Test
	public void test3(){
		// instantiate default z3 context for contraint solving
		Context ctx = new Context();
		// input matrix: each row denotes a requirement or coverage element, while each column denotes a test
		int[][] instance = { { 1, 0, 1, 0 }, { 0, 0, 0, 1 },{ 0, 0, 1, 0 }, { 1, 0, 0, 0 } };
		// expected reduced test suite, including only the first, third, and fourth tests
		Set<Integer> expected=new HashSet<Integer>(Arrays.asList(1, 3, 4));
		// run the reduction and get the actual reduced test suite
		Set<Integer> reduced=IntegerModel.TestReduction(ctx, instance);
		// check if the reduced test set is as expected
		assertEquals(expected, reduced);
	}


}
