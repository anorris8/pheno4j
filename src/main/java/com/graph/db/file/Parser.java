package com.graph.db.file;

import java.util.EnumSet;

import com.graph.db.output.OutputFileType;

public interface Parser {

	void execute();
	
	EnumSet<OutputFileType> getNonHeaderOutputFileTypes();
}