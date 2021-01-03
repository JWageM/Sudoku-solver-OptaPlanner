package sudoku;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.CountableValueRange;
import org.optaplanner.core.api.domain.valuerange.ValueRangeFactory;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity()
public class Vakje {
	
	@PlanningVariable(valueRangeProviderRefs = {"delayRange"}, nullable = true)
	public Integer cijfer;
	
	public boolean fixed = false;
	
	/*public void setCijfer(Integer integer) {
		cijfer = integer;
	}*/

	public Vakje(){
		
	}
	
	public Vakje(Integer inputCijfer){
		cijfer = inputCijfer;
	}
	public Vakje(Integer inputCijfer, boolean inputFixed){
		cijfer = inputCijfer;
		fixed = inputFixed;
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
