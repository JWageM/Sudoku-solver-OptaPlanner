package sudoku;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HardSoftScoreCalculator implements EasyScoreCalculator<Sudoku>{

	@Override
	public Score calculateScore(Sudoku solution) {
        int hardScore = 0;
        int softScore = 0;
        
        int n = 9;
        int n2 = (int)Math.pow(n, 2);
        int ns = (int)Math.sqrt(n);
        
        // Constraint: geen gelijke getallen in een kolom.
        //IntStream stream = IntStream.of(solution.vakjesList.forEach((vakje) -> vakje.cijfer));
        //solution.vakjesList.stream().map((Vakje vakje) -> {return vakje.cijfer;});
        //System.out.println((int)Math.pow(n, 2));     
        //System.out.println(solution.vakjesList.stream().mapToInt((Vakje vakje) -> {return vakje.cijfer;}).distinct().count());

        //System.out.println((-(int)Math.pow(n, 2))+solution.vakjesList.stream().mapToInt((Vakje vakje) -> {return vakje.cijfer;}).distinct().count());
        //hardScore += (-(int)Math.pow(n, 2))+solution.vakjesList.stream().mapToInt((Vakje vakje) -> {return vakje.cijfer;}).distinct().count();        
        //https://www.geeksforgeeks.org/stream-maptoint-java-examples/
        
        //In één kolom wil je distict.
        // We gebruiken een truuk van: https://www.baeldung.com/java-stream-indices
        for (int j = 0; j<n; j++) {
        final int k = j;
        //System.out.println("k = "+k);
        int distincts_in_kol = (int) IntStream
        .range(0, n2)
        .filter(i->(i + k) % n == 0) // Hier pakken we één kolom.
        .map(i->solution.vakjesList.get(i).cijfer)
        .distinct()
        .count();
        /*
        System.out.println("Alleen range");
        System.out.println(IntStream
                .range(0, n2)
                .boxed()
                .collect(Collectors.toList())
                );// https://stackoverflow.com/questions/28280721/java-8-streams-intstream-to-string
        System.out.println("Range en filter");
        System.out.println(IntStream
                .range(0, n2)
                .filter(i->i  % n == 0) // Hier pakken we één kolom.
                .boxed()
                .collect(Collectors.toList())
                );// https://stackoverflow.com/questions/28280721/java-8-streams-intstream-to-string
        System.out.println("Range en filter met k");
        System.out.println(IntStream
                .range(0, n2)
                .filter(i->(i + k)  % n == 0) // Hier pakken we één kolom. // Belangrijk, gebruik haakjes bij de optelling, blijkbaar heeft die een lagere rang dan modulo.
                .boxed()
                .collect(Collectors.toList())
                );// https://stackoverflow.com/questions/28280721/java-8-streams-intstream-to-string        
        System.out.println(IntStream
                .range(0, n2)
                .filter(i->i + k % n == 0) // Hier pakken we één kolom.
                .map(i->solution.vakjesList.get(i).cijfer)
                .distinct()
                .boxed()
                .collect(Collectors.toList())
                );// https://stackoverflow.com/questions/28280721/java-8-streams-intstream-to-string
        // https://www.baeldung.com/java-intstream-convert
		*/
        hardScore += -n + distincts_in_kol;
        }
        
        // Nu voor de rijen
        for (int j = 0; j<n; j++) {
        final int k = j;
        int distincts_in_rows = (int) IntStream
                .range(0, n)
                .map(i->solution.vakjesList.get(i+(k*n)).cijfer)// Door de plus k gaan we over de rijen.
                .distinct()
                .count();
        hardScore += -n + distincts_in_rows;
        }
        
        
        //Nu voor blokken.
        for (int i=0; i<ns; i++) {
        	for (int j=0; j<ns; j++) {
        		int[] indexes = new int[9];
        		for (int k=0; k<ns; k++) {
        			for (int l=0; l<ns; l++) {
        				int index = (i*n*ns)+(j*ns)+(k*n)+l;
        				//System.out.print(", "+index);
        				indexes[k*ns+l]=index; 
        			}
        		} 
        		// Constraint maken.
        		int distincts_in_rows = 
        		(int) Arrays.stream(indexes)
                .map(m->solution.vakjesList.get(m).cijfer)// Door de plus k gaan we over de rijen.
                .distinct()
                .count();        		
        		hardScore += -n + distincts_in_rows;
        	}       	
        }
        
        //System.out.println("Hardscore: "+hardScore+", softscore: "+softScore);
        return HardSoftScore.of(hardScore, softScore);
	}
	
	public static void main(String[] args) {
        int n = 9;
        int n2 = (int)Math.pow(n, 2);
        int ns = (int)Math.sqrt(n);		
        for (int i=0; i<ns; i++) {
        	for (int j=0; j<ns; j++) {
        		System.out.println("i: "+i+",j: "+j);
        		int[] indexes = new int[9];
        		for (int k=0; k<ns; k++) {
        			for (int l=0; l<ns; l++) {
        				int index = (i*n*ns)+(j*ns)+(k*n)+l;
        				System.out.print(", "+index);
        				indexes[k*ns+l]=index;       				
        			}
        			System.out.println("");
        		}        	        		
        	}       	
        }
        System.out.println("end");
	}
	

}
