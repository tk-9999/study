package annotationSample.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)

@Target({
	ElementType.TYPE
})

/**
 * 拡張子名を持たせるアノテーション
 *
 */
public @interface FileTypeCheckAnnotation {

	public static final String[] fileNameExtension = {};

	public String[] filenameExtension();
}