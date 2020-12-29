package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import sudoku.Vakje;

public class HelloWorld {


/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
package org.optaplanner.examples.nqueens.app;

import java.util.List;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.nqueens.domain.NQueens;
import org.optaplanner.examples.nqueens.domain.Queen;
import org.optaplanner.examples.nqueens.persistence.NQueensGenerator;
*/



    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<Sudoku> solverFactory = SolverFactory.createFromXmlResource(
                "sudoku/solver_conf.xml");
        Solver<Sudoku> solver = solverFactory.buildSolver();

       Sudoku sudoku = new Sudoku();
       List<Vakje> vakjesList= new ArrayList<>();
       int n = 9;
       for(int i = 0; i < n; i++) {
    	   for(int j = 0; j < n; j++) {
    		   vakjesList.add(new Vakje(i,(j%n==0)));
    		   System.out.println(i+j);
    	   }
    	   
       }
       
       //Vakje vak1 = new Vakje();
       //vak1.cijfer = new Integer(1);
       //Vakje vak2 = new Vakje();
       //vak2.cijfer = new Integer(2);   
       //vakjesList.add(vak1);
       //vakjesList.add(vak2);
       sudoku.vakjesList=vakjesList;
       	   
        
        //// Load a problem with 8 queens
        //NQueens unsolved8Queens = new NQueensGenerator(true).createNQueens(8);

        // Solve the problem
        //NQueens solved8Queens = solver.solve(unsolved8Queens);
       Sudoku solvedSudoku = solver.solve(sudoku);
       for(int i = 0; i < n; i++) {
    	   for(int j = 0; j < n; j++) {
    	       System.out.println(solvedSudoku.vakjesList.get(j+n*i).cijfer);
    	   }
    	   
       }
       
       for (int j = 0; j<n; j++) {
       final int k = j;
       System.out.println( IntStream
               .range(0, n)
               .map(i->solvedSudoku.vakjesList.get(i+(k*n)).cijfer)// Door de plus k gaan we over de rijen.
               .boxed()
               .collect(Collectors.toList()));
      
       }
       //System.out.println(solvedSudoku.vakjesList.get(0).cijfer);
       //System.out.println(solvedSudoku.vakjesList.get(1).cijfer);
       
        // Display the result
       // System.out.println("\nSolved 8 queens:\n" + toDisplayString(solved8Queens));
    }
/*
    public static String toDisplayString(NQueens nQueens) {
        StringBuilder displayString = new StringBuilder();
        int n = nQueens.getN();
        List<Queen> queenList = nQueens.getQueenList();
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                Queen queen = queenList.get(column);
                if (queen.getColumn().getIndex() != column) {
                    throw new IllegalStateException("The queenList is not in the expected order.");
                }
                displayString.append(" ");
                if (queen.getRow() != null && queen.getRow().getIndex() == row) {
                    displayString.append("Q");
                } else {
                    displayString.append("_");
                }
            }
            displayString.append("\n");
        }
        return displayString.toString();
    }
*/
}
