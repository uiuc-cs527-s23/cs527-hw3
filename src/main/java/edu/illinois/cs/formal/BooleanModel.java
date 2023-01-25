package edu.illinois.cs.formal;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Model;
import com.microsoft.z3.Optimize;
import com.microsoft.z3.Status;

public class BooleanModel
{
	/**
	 * Takes a coverage matrix (rows as the statements while columns as the
	 * tests) as input and return the reduced set of tests
	 * 
	 * @param ctx the solver context
	 * @param instance the input coverage matrix used for test reduction
	 */
	public static Set<Integer> TestReduction(Context ctx, int[][] instance) {
		Set<Integer> reduced = new HashSet<Integer>();
		int reqNum = instance.length;
		int tstNum = instance[0].length;
		// matrix of boolean variables to represent the coverage matrix
		BoolExpr[][] c = new BoolExpr[reqNum][tstNum];
		for (int i = 0; i < reqNum; i++) {
			for (int j = 0; j < tstNum; j++) {
				c[i][j] = (BoolExpr) ctx.mkBoolConst("c" + (i + 1) + (j + 1));
			}
		}
		// vector of boolean variables to represent the tests
		BoolExpr[] t = new BoolExpr[tstNum];
		for (int i = 0; i < tstNum; i++) {
			t[i] = (BoolExpr) ctx.mkBoolConst("t" + (i + 1));
		}

		// TODO: add your implementation. 
		// Hint1: you shall use the following example code to formulate and solve the integer optimization problem 
		// Optimize opt = ctx.mkOptimize(); // instantiate the optimization problem
		// opt.Add(...); // add all constraints
		// opt.MkMinimize(...); // find the solution that minimizes some objective function, i.e., the number of tests for this problem
		// Hint2: you can use "y[i] = (IntExpr) ctx.mkITE(x[i], ctx.mkInt(1), ctx.mkInt(0));" to transform boolean variables into integer variables for computing the number of tests as the objective function 
		return reduced;
	}

}
