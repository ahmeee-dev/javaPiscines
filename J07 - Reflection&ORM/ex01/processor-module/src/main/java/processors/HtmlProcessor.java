package processors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

import com.google.auto.service.AutoService;

import annotations.HtmlForm;
import annotations.HtmlInput;


@AutoService(Processor.class)
@SupportedAnnotationTypes("annotations.*")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class HtmlProcessor extends AbstractProcessor {
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element elem : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
			HtmlForm htmlForm = elem.getAnnotation(HtmlForm.class);
			String fileName = htmlForm.fileName();
			String action = htmlForm.action();
			String method = htmlForm.method();
			try { FileObject fileObject = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", fileName);
				try (PrintWriter printWriter = new PrintWriter(fileObject.openWriter())) {
						printWriter.println("<form action = \"" + action + "\" method = \"" + method + "\">");
						for (Element inputs : roundEnv.getElementsAnnotatedWith(HtmlInput.class)) {
							HtmlInput htmlInput = inputs.getAnnotation(HtmlInput.class);
							String type = htmlInput.type();
							String name = htmlInput.name();
							String placeholder = htmlInput.placeholder();
							printWriter.println("\t<input type = \""+  type + "\" name = \"" + name +"\" placeholder = \"" + placeholder + "\">");
						}
						printWriter.println("\t<input type = \"submit\" value = \"Send\">");
						printWriter.println("</form>");
				} catch (IOException err) { processingEnv.getMessager().printError(err.getMessage());}

			} catch (IOException err) {	processingEnv.getMessager().printError(err.getMessage()); }
		}
		return true;
	}
}
