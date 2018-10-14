package com.ps.annotation.api.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes(value= {"com.ps.annotation.api.Test"})
@SupportedSourceVersion(value=SourceVersion.RELEASE_8)
public class TestAnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("Annotation Processor Begin Work");
		for(TypeElement element : annotations) {
			System.out.println(element);
		}
		System.out.println(roundEnv);
		return true;
	}

	

}
