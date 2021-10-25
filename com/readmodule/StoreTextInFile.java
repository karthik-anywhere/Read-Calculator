package com.readmodule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreTextInFile extends FileContainer {

	@Override
	public List<File> getFile() {
		List<File> files = new ArrayList<File>();
		try {
			File file = new File("textFile.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(name);
			bw.close();
			files.add(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return files;

	}

}
