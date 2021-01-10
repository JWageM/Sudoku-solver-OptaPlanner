package sudoku;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

public class VakjeDifficultyWeightsFactory implements SelectionSorterWeightFactory<Sudoku, Vakje> {
	
	static int tie_braker = 0;
	
	@Override
	public Comparable createSorterWeight(Sudoku solution, Vakje vakje) {
		// TODO Auto-generated method stub
		int numberOfValidMoves;
		if (vakje.fixed) {
			numberOfValidMoves = 0;			
		}else {
			numberOfValidMoves = 9 - (int) solution.vakjesList.stream()
					.filter(i-> (i.horizontal == vakje.horizontal || i.vertical == vakje.vertical || i.blok == vakje.blok))
					.filter(i->i.cijfer != null)
					.mapToInt(i->i.cijfer)
					.distinct()
					.count(); //TODO fill			
			
		}

		
		return new VakjeDifficultyWeight(vakje, numberOfValidMoves);
	}
	
	public static class VakjeDifficultyWeight implements Comparable<VakjeDifficultyWeight>{
		private final Vakje vakje;
		private final int numberOfValidMoves;
		
		public VakjeDifficultyWeight(Vakje vakje, int numberOfValidMoves) {
			this.vakje = vakje;
			this.numberOfValidMoves = numberOfValidMoves;
		}
		
		@Override
		public int compareTo(VakjeDifficultyWeight other) {
			tie_braker++;

			
			// TODO Auto-generated method stub
			return new CompareToBuilder()
                    // The more difficult queens have a lower distance to the middle
                    .append(other.numberOfValidMoves, numberOfValidMoves) // Decreasing
                    // Tie breaker
                    .append(0, tie_braker)
                    //.append(queen.getColumnIndex(), other.queen.getColumnIndex())
                    .toComparison();
		}
		
		
	}

}
