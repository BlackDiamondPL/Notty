package org.notty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileIO {
	private BufferedReader flBufferIn;
        private BufferedWriter flBufferOut;
	
	public ArrayList<String> readFile(String file) {
		ArrayList<String>data = new ArrayList<>();
		try {
			flBufferIn = new BufferedReader(new InputStreamReader(
                                new FileInputStream(file)));
			String dataline = flBufferIn.readLine();
			while(dataline!=null) {
				data.add(dataline);
				dataline = flBufferIn.readLine();
			}
			flBufferIn.close();
		} catch (FileNotFoundException FNFE) {
			System.out.println(FNFE.getMessage());
			FNFE.printStackTrace();
		}catch(IOException IOExce) {
			System.out.println(IOExce.getMessage());
			IOExce.printStackTrace();
		}
		
		return(data);
	}
	
	public int writeFile(File svFile,String saveCtn) {
		try {
			if(!svFile.exists()) {
				svFile.createNewFile();
			}
			flBufferOut = new BufferedWriter(new FileWriter(svFile));
			flBufferOut.write(saveCtn);
			flBufferOut.close();
		}catch(IOException IOExce) {
			System.out.println(IOExce.getMessage());
			IOExce.printStackTrace();
		}
		return 0;
	}
}
