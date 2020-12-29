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
    	
    	vakjesList= new ArrayList<>();
    	for (int i = 0; i<n; i++) {
    		for (int j = 0; j<n; j++) {
    			int temp = matrix[i][j];
    			vakjesList.add(new Vakje(temp,temp!=0)); // a value of 0 means an open field.

    			
    		}
    		
    	}
    	
    }
}
