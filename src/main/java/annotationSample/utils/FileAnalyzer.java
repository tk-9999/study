package annotationSample.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Set;

import org.reflections.Reflections;

import annotationSample.annotation.FileTypeCheckAnnotation;

public class FileAnalyzer {


	public FileAnalyzer() {

	}

	/**
	 * ファイルに対応する FileTypeCheckAnnotation　を持つ Analyzer クラス名を表示する
	 * @param file
	 */
	public void analyze(File file) {

		String ext = getFileExtension(file);

		Class<?> analyzerClass = getAnnotation(ext);

		if(analyzerClass != null) {
			System.out.println(analyzerClass.getName());
		}else {
			System.out.println("指定されたファイルの拡張子に対応するクラスは存在しません。");
		}

	}

	/**
	 * ファイルの拡張子を取得する
	 * @param file
	 * @return
	 */
	private String getFileExtension(File file) {
	    String name = file.getName();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return "";
	    }
	    return name.substring(lastIndexOf).replace(".","");
	}

	/**
	 * 引数の拡張子を持つ FileTypeCheckAnnotation　クラスを返す
	 * @param fileExtension
	 * @return
	 */
	private Class<?> getAnnotation(String fileExtension) {

		Reflections reflections = new Reflections("annotationSample");
		Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(FileTypeCheckAnnotation.class);

		for(Class<?> analyzerClass :allClasses) {
			FileTypeCheckAnnotation analyzerClasses = analyzerClass.getAnnotation(FileTypeCheckAnnotation.class);
			String[] extensions = analyzerClasses.filenameExtension();
			if(Arrays.asList(extensions).contains(fileExtension)) {
				return analyzerClass;
			}
		}
		return null;
	}



}
