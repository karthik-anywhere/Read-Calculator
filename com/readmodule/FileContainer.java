package com.readmodule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.input.UserInput;

public abstract class FileContainer {

	public String name;

	public Map<String, String> fileStore = new HashMap<String, String>();

	public abstract List<File> getFile();

	public void getUserInput(int option) throws InputMismatchException {
		switch (option) {
		case 1:
			System.out.println("Enter Directory path for files: ");
			name = UserInput.getStringUserInput();
			break;
		case 2:
			System.out.println("Enter File name to read: ");
			name = UserInput.getStringUserInput();
			break;
		case 3:
			System.out.println("Enter String to read: ");
			name = UserInput.getStringUserInput();
			break;
		default:
			throw new InputMismatchException("input mismatch");
		}
	};

	private void addTxtFileOnly(File file) {
		if (file.getName().endsWith(".txt")) {
			Scanner s;
			try {
				s = new Scanner(file);
				String content = "";
				while (s.hasNextLine()) {
					content = content + "\n" + s.nextLine();
				}
				s.close();
				fileStore.put(file.getName(), content);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void addFileToFileContainer(List<File> fileList) {

		for (File f : fileList) {
			addTxtFileOnly(f);
		}
	}

}
