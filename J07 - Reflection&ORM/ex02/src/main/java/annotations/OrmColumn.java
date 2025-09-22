package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrmColumn {
	String name();
	String StringValue() default "";
	int length() default 255;
	int intValue() default 0;
	boolean boolValue() default false;
	long longValue() default 0;
	double doubleValue() default 0.0;
}
