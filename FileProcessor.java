import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	/**
	 * Creates a FileProcessor object with a fileName and stringLenth restriction.
	 * @param fileName
	 * @param stringLength
	 */
	public FileProcessor(String fileName, int stringLength){
		
		setFileName(fileName);
		setStringLength(stringLength);
		
	}//end empty-argument constructor
	
	/** 
	 * @return Size of String list as an integer
	 */
	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	/**
	 * Reads through specified text file line by line, and if any string exceeds the string length 
	 * restriction set when the object was created, then a StringTooLongException is thrown. It also checks 
	 * for a FileNotFoundException.
	 * 
	 * @throws StringTooLongException
	 */
	public void processFile() throws StringTooLongException{
		
		try {
		FileReader fr = new FileReader(getFileName());
		input = new Scanner(fr);
		String line;
		
		while (input.hasNextLine()) {
			try {
				line = input.nextLine(); 
			if (line.length() > stringLength) {
				throw new StringTooLongException("String is too long!");
				}
			}
			catch(StringTooLongException e) {
				System.out.println(e.getMessage());
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}//end processFile

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}//end getFileName

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}//end setFileName

	/**
	 * @return the stringLength
	 */
	public int getStringLength() {
		return stringLength;
	}//end getStringLength

	/**
	 * @param stringLength the stringLength to set. If String length is less than 5, then length is defaulted to 5.
	 */
	public void setStringLength(int stringLength) {
		if (stringLength < 5) {
			this.stringLength = 5;
		}
		else {
		this.stringLength = stringLength;
		}
	}//end setStringLength
	
	
}//end class
