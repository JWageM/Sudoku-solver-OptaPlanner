package sudoku;

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
}
