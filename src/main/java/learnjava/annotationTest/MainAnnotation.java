package learnjava.annotationTest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class MainAnnotation {
    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass("hello");
        System.out.println(baseClass.val);
        Annotation[] annotation = baseClass.getClass().getAnnotations();
        for(Annotation a: annotation) {
            System.out.println(a);
        }

        System.out.println("getAnnotationsByType");
        MyAnnotation[] testArray = baseClass.getClass().getAnnotationsByType(MyAnnotation.class);
        for(Annotation a: testArray) {
            System.out.println(a);
        }
        //System.out.println(annotation.value());
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatMyAnnotation.class)
@interface MyAnnotation {
    String value() default "hi";
    int amount() default 3;
}

@Retention(RetentionPolicy.RUNTIME)
@interface RepeatMyAnnotation {
    MyAnnotation[] value();
}


@MyAnnotation(value = "bye", amount = 6)
@MyAnnotation("cya")
class BaseClass {
    String val;

    BaseClass(String val) {
        this.val = val;
    }
}