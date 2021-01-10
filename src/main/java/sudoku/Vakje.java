package sudoku;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.CountableValueRange;
import org.optaplanner.core.api.domain.valuerange.ValueRangeFactory;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity()
public class Vakje {
	
	@PlanningVariable(valueRangeProviderRefs = {"delayRange"}) //TODO: in NQueens they refer to the difficulty weightsfactory here, do we need that or does that happen in the solver config?
	public Integer cijfer;
	
	public int horizontal; // These are problemfacts. TODO: do we need to annotate them?
	public int vertical;
	public int blok;
	
	public boolean fixed = false;
	
	/*public void setCijfer(Integer integer) {
		cijfer = integer;
	}*/

	public Vakje(){ // I recall this was needed.
		
	}
	/*
	public Vakje(Integer inputCijfer){
		cijfer = inputCijfer;
	}
	*/
	public Vakje(Integer inputCijfer, int horizontal, int vertical, int blok,  boolean inputFixed){
		cijfer = inputCijfer;
		fixed = inputFixed;
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.blok = blok;
		
	}
	public int n = 9;
	
	@ValueRangeProvider(id = "delayRange")
    public CountableValueRange<Integer> getDelayRange() {
		if (fixed == false) {
			        return ValueRangeFactory.createIntValueRange(1, 1+n); // Let op: als je initializeerd buiten deze range, dan kan de variable niet meer worden aangepast.		
		}else {
			
	        return ValueRangeFactory.createIntValueRange(cijfer, cijfer+1); // Met deze clausule kunnen we waarden instellen die vast staan.	

		}
    } // Let op, deze range is een beetje gek, hij is niet helemaal hoe ik zou verwachten.
}
