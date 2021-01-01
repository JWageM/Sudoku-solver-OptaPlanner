package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.optaplanner.benchmark.api.PlannerBenchmark;
import org.optaplanner.benchmark.api.PlannerBenchmarkFactory;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import sudoku.Vakje;

public class HelloWorld {


/*
 * Copyright 2020 Jens Wagemaker.
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




    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<Sudoku> solverFactory = SolverFactory.createFromXmlResource(
                "sudoku/solver_conf.xml");
        Solver<Sudoku> solver = solverFactory.buildSolver();

        int[][] matrix = ImportCsv.matrixFromCsv("sudoku_2_star.csv");
        Sudoku sudoku = new Sudoku(matrix);
        /*
       Sudoku sudoku = new Sudoku();
       List<Vakje> vakjesList= new ArrayList<>();
       int n = 9;
       for(int i = 0; i < n; i++) {
    	   for(int j = 0; j < n; j++) {
    		   vakjesList.add(new Vakje(i,(j%n==0)));
    		   System.out.println(i+j);
    	   }
    	   
       }
       */
       
       //Vakje vak1 = new Vakje();
       //vak1.cijfer = new Integer(1);
       //Vakje vak2 = new Vakje();
       //vak2.cijfer = new Integer(2);   
       //vakjesList.add(vak1);
       //vakjesList.add(vak2);
       
        //sudoku.vakjesList=vakjesList;
       	   
        
       // Benchmark 

        PlannerBenchmarkFactory benchmarkFactory = PlannerBenchmarkFactory.createFromSolverConfigXmlResource( "sudoku/solver_conf.xml");
        PlannerBenchmark benchmark = benchmarkFactory.buildPlannerBenchmark(sudoku); //https://docs.optaplanner.org/7.27.0.Final/optaplanner-docs/html_single/#benchmarker
        benchmark.benchmarkAndShowReportInBrowser();
     	
     
        
        /*
        // Solve the problem
       Sudoku solvedSudoku = solver.solve(sudoku);
       
       int n=9;
       for(int i = 0; i < n; i++) {
    	   for(int j = 0; j < n; j++) {
    	       System.out.print(solvedSudoku.vakjesList.get(j+n*i).cijfer);
    	       System.out.print(",");
    	   }
    	   System.out.println("");
    	   
       }
              
       // Laat de score van de oplossing zien:
       HardSoftScoreCalculator calculator = new HardSoftScoreCalculator();
       calculator.calculateScore(solvedSudoku);
       */
       
       /*
       for (int j = 0; j<n; j++) {
       final int k = j;
       System.out.println( IntStream
               .range(0, n)
               .map(i->solvedSudoku.vakjesList.get(i+(k*n)).cijfer)// Door de plus k gaan we over de rijen.
               .boxed()
               .collect(Collectors.toList()));
      
       }
       */
       
       
       //System.out.println(solvedSudoku.vakjesList.get(0).cijfer);
       //System.out.println(solvedSudoku.vakjesList.get(1).cijfer);
       

    }

}
