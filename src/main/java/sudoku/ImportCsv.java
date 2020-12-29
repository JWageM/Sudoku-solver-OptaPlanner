package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ImportCsv {

	
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		String fileName = "sudoku.csv";
		ImportCsv dummy = new ImportCsv();
		File file = dummy.getFileFromResources(fileName);
		FileReader fr;
		int n=9;
		int[][] matrix = new int[n][];
		try {
			fr = new FileReader(file);
			
			try (BufferedReader br = new BufferedReader(fr)){

				// read the first line from the text file 
				String line = br.readLine(); 
				// loop until all lines are read 
				int j = 0;
				while (line != null) { // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter String[] attributes = line.split(","); Book book = createBook(attributes); // adding book into ArrayList books.add(book); // read next line before looping // if end of file reached, line would be null line = br.readLine(); } } catch (IOException ioe) { ioe.printStackTrace(); }
					String[] attributes = line.split(",");
					
					// We zetten de Strings om naar Char
					Stream<String> stringStream = Arrays.stream(attributes); //https://mkyong.com/java8/java-how-to-convert-array-to-stream/
					matrix[j] = stringStream
					.map(i->Character.getNumericValue(i.charAt(0)))
					.mapToInt(i -> i)//https://stackoverflow.com/questions/28015278/convert-stream-to-intstream
					.toArray();
					// https://www.javatpoint.com/java-char-to-int
					line = br.readLine();
					j++;
				}
			}catch (IOException ioe) {
	            ioe.printStackTrace();
	        }		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //https://stackoverflow.com/questions/42916413/read-from-file-with-bufferedreader
		
	System.out.println("end");
		
				
	}
	
	public static int[][] matrixFromCsv(String fileName){
		

		ImportCsv dummy = new ImportCsv();
		File file = dummy.getFileFromResources(fileName);
		FileReader fr;
		int n=9;
		int[][] matrix = new int[n][];
		try {
			fr = new FileReader(file);
			
			try (BufferedReader br = new BufferedReader(fr)){

				// read the first line from the text file 
				String line = br.readLine(); 
				// loop until all lines are read 
				int j = 0;
				while (line != null) { // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter String[] attributes = line.split(","); Book book = createBook(attributes); // adding book into ArrayList books.add(book); // read next line before looping // if end of file reached, line would be null line = br.readLine(); } } catch (IOException ioe) { ioe.printStackTrace(); }
					String[] attributes = line.split(",");
					
					// We zetten de Strings om naar Char
					Stream<String> stringStream = Arrays.stream(attributes); //https://mkyong.com/java8/java-how-to-convert-array-to-stream/
					matrix[j] = stringStream
					.map(i->Character.getNumericValue(i.charAt(0)))
					.mapToInt(i -> i)//https://stackoverflow.com/questions/28015278/convert-stream-to-intstream
					.toArray();
					// https://www.javatpoint.com/java-char-to-int
					line = br.readLine();
					j++;
				}
			}catch (IOException ioe) {
	            ioe.printStackTrace();
	        }		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //https://stackoverflow.com/questions/42916413/read-from-file-with-bufferedreader
		
	System.out.println("end");		
	return matrix;
		
	}
	
	public File getFileFromResources(String fileName) {// https://java2blog.com/read-file-from-resources-folder-in-java/
		
		   // Getting ClassLoader obj
		   ClassLoader classLoader = this.getClass().getClassLoader();
		   // Getting resource(File) from class loader
		   return new File(classLoader.getResource(fileName).getFile());
	}

}
