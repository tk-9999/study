package annotationSample;

import java.io.File;

import annotationSample.utils.FileAnalyzer;

public class Application {

	public static void main(String[] args) {

		String path = "src/mainresources/annotationSample/test.jpg";
		File file = new File(path);

		FileAnalyzer fa = new FileAnalyzer();
		fa.analyze(file);


	}

}
