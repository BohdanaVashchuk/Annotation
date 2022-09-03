package AnnotationHomeWork;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomAnnotation {
 String firstName ();
//    String lastName ();
//    String companyName () default "Epam";
//    int age() default 16;



}
