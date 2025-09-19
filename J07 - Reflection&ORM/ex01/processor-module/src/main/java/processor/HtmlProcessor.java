package processor;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

import com.google.auto.service.AutoService;

@SupportedAnnotationTypes({
	"annotations.HtmlForm",
	"annotations.HtmlInput"
})
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class HtmlProcessor extends AbstractProcessor {
	
	// @Override
	// public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
	// 	for (Element element : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
	// 		HtmlForm htmlForm = element.getAnnotation(HtmlForm.class);
	// 		String fileName = htmlForm.fileName();

	// 		try {
	// 			FileObject file = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", fileName);
	// 			try (Writer writer = file.openWriter()) {
	// 				writer.write("<form action = \"" +htmlForm.action());
	// 			}
	// 		} catch (IOException err) { System.err.println(err.getMessage()); }
	// 	}
	// 	return true;
	// }
	@Override
public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    System.out.println("ok ci siamo");
	try {
        FileObject file = processingEnv.getFiler()
            .createResource(StandardLocation.CLASS_OUTPUT, "", "user_form.html");

        try (Writer writer = file.openWriter()) {
            writer.write("<form action='/users' method='post'>\n");
            writer.write("  <input type='text' name='first_name'>\n");
            writer.write("</form>\n");
        }

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    return true;
}
}
