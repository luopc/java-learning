package com.luopc.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

	public static void main(String[] args) {
		String baseDir = System.getProperty("user.dir");
		System.out.println(baseDir);
		Path basePath = Paths.get(baseDir);
		System.out.println(basePath.getRoot());
		Path workRelative = Paths.get("work");
		System.out.println(workRelative);
		Path workPath = basePath.resolve(workRelative);
		System.out.println(workPath);
		Path tempPath = workPath.resolve("temp");
		System.out.println(tempPath);

	}

}
