package AnnotationHomeWork;

public class SomeClass {
    @CustomAnnotation(firstName = "Dana")
    public int age;
    @CustomAnnotation(firstName = "Dana")
    String name;

    String lastName;


    public String welcome(String name) {
        return "Welcome " + name;
    }
    public Integer yourAge(Integer age) {
        return age;
    }
    public Double accountSum(Double str) {
        return 323.32 + str;
    }

    public void myMethod(String a, int... b){
        System.out.println("Text is shown after running the method with string and int...");
    }

    public void myMethod(String ... args){
        System.out.println("Text is shown after running the method with string...");
    }
}
