package com.readmodule;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryFileReader extends FileContainer {
	public List<File> getFile() {
		File[] fileList = new File(name).listFiles();
		List<File> files = new ArrayList<File>(Arrays.asList(fileList));
		return files;
	}
}
