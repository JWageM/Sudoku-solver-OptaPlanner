package sudoku;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;


@PlanningSolution
public class Sudoku {
	
	@PlanningEntityCollectionProperty
	public List<Vakje> vakjesList; // Kunnen we hier een Array van maken?
	
    @PlanningScore
    public HardSoftScore score;
    
    public Sudoku() {
    	
    }
    
    public Sudoku(int[][] matrix) {
    	int n = matrix.length; // We assume that the matrix is square.
    	int ns = (int)Math.sqrt(n);
    	
    	vakjesList= new ArrayList<>();
    	for (int i = 0; i<n; i++) {
    		for (int j = 0; j<n; j++) {
    			Integer temp = matrix[i][j];
    			boolean fixed = (temp != 0);
    			if (!fixed) {
    				temp = null; // 0 means uninstantiated.// Tabu-search needs an initialized solution
    			}
    			vakjesList.add(new Vakje(temp,i,j,(((i/ns)-1)*ns) + (j/ns)-1,fixed)); //TODO checken of het blok goed gaat. 

    			
    		}
    		
    	}
    	
    }
    
    public void print() {
    	
        int n=9;
        for(int i = 0; i < n; i++) {
     	   for(int j = 0; j < n; j++) {
     		   Integer temp = this.vakjesList.get(j+n*i).cijfer;
     		   if (temp == null) {
     			  System.out.print(0);
     		   }else {
      			  System.out.print(temp);
   			   
     			   
     		   }
     	       System.out.print(",");
     	   }
     	   System.out.println("");
     	   
        }
    }
}
