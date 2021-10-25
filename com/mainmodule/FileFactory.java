package com.mainmodule;

import com.readmodule.DirectoryFileReader;
import com.readmodule.FileContainer;
import com.readmodule.FileReader;
import com.readmodule.StoreTextInFile;

public class FileFactory {

	static FileContainer getType(int option) {
		switch (option) {
		case 1:
			return new DirectoryFileReader();
		case 2:
			return new FileReader();
		case 3:
			return new StoreTextInFile();
		default:
			System.out.println("Please Enter valid Option!");
			return null;
		}

	}

}
