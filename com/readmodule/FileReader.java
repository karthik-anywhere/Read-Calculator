package com.readmodule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader extends FileContainer {

	@Override
	public List<File> getFile() {
		File file = new File(name);
		List<File> files = new ArrayList<File>();
		files.add(file);
		return files;
	}
}
