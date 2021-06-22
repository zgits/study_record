package annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author KiroLox
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE,ElementType.FIELD,ElementType.METHOD})
public @interface Test {

    int id() default -1;

    String msg() default "annotation";
}
