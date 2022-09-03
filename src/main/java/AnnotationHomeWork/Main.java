package AnnotationHomeWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class Main {
    static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
//        getFieldWithAnnotation();
//        getAnnotationValue();
//        invokeMethods();
//        setValueToField();
//        myMethods();
        showInfoAboutClass();

    }

    public static void getFieldWithAnnotation() throws Exception {
        Class someClass = SomeClass.class;
        Field[] fields = someClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CustomAnnotation.class)) {
                LOGGER.info(field);
            }
        }
    }

    public static void getAnnotationValue() throws Exception {
        Class someClass = SomeClass.class;
        Field[] fields = someClass.getDeclaredFields();
        for (Field ann : fields) {
            CustomAnnotation customAnnotation = ann.getDeclaredAnnotation(CustomAnnotation.class);
            if (customAnnotation != null)
                LOGGER.info(customAnnotation.firstName());
        }
    }

    public static void invokeMethods() throws Exception {
        Class<?> someClass = SomeClass.class;
        Method method = someClass.getMethod("welcome", String.class);
        Object obj = someClass;
        String output = (String) method.invoke(obj, "Dana");
        LOGGER.info(output);


        Method method1 = someClass.getMethod("yourAge", Integer.class);
        Integer outputAge = (Integer) method1.invoke(obj, 25);
        LOGGER.info("Your age " + outputAge);

        Method method2 = someClass.getMethod("accountSum", Double.class);
        Double outputSum = (Double) method2.invoke(obj, 3434.43);
        LOGGER.info("Your account balance is " + outputSum);

    }

    public static void setValueToField() throws Exception {
        Class<?> classObj = SomeClass.class;
        Field ageField = classObj.getDeclaredField("age");
        Object person = classObj;
        ageField.setInt(person, 45);
        Object ageValue = ageField.get(person);
        LOGGER.info("age = " + ageValue);
    }

    public static void myMethods() throws Exception {
        Class<?> someClass = SomeClass.class;
        Method method = someClass.getMethod("myMethod", String[].class);
        Object obj = someClass.newInstance();
        method.invoke(obj, (Object) new String[]{"Some text 1", "Some text 2"});

        Method method2 = someClass.getMethod("myMethod", String.class, int[].class);
        method2.invoke(obj, "Some text", (Object) new int[]{1, 2, 3});
    }

    public static void showInfoAboutClass() throws Exception {
        Class<?> classObj = SomeClass.class;
        Method[] methods = classObj.getDeclaredMethods();
        for (Method method : methods) {
            LOGGER.info(method);
        }
        Constructor[] constructors = classObj.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            LOGGER.info(constructor);
        }
        Field[] fields = classObj.getDeclaredFields();
        for (Field field : fields) {
            LOGGER.info(field);
        }
    }


}
