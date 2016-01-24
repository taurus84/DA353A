package p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadWriteLines
{
	public ReadWriteLines()
	{
		
	}
	
	public String[] OpenFile(String path) throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = getNumberOfLines(path);
		String[] textData = new String[numberOfLines];

		for (int i = 0; i < numberOfLines; i++)
		{
			textData[i] = textReader.readLine();
		}
		
		textReader.close();
		
		return textData;
	}
	
	int getNumberOfLines(String path) throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = 0;
		
		while (textReader.readLine() != null)
		{
			numberOfLines++;
		}
		
		textReader.close();
		
		return numberOfLines;
	}
	
	public void Write(String path) throws IOException
	{
		FileWriter fw = new FileWriter(path);
		BufferedWriter textWriter = new BufferedWriter(fw);
		
		textWriter.write("Jonas 10 5.5 Ja");
		
		textWriter.close();
	}
}
