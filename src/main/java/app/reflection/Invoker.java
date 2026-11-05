package main.java.app.reflection;
import java.lang.reflect.Method;
public class Invoker {
    public static void invokerAnnotatedMethods(){
        MyClass obj = new MyClass();
        Class<?> clazz = MyClass.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods){
            if (method.isAnnotationPresent(Repeat.class)){
                Repeat repeat = method.getAnnotation(Repeat.class);
                int times = repeat.times();
                method.setAccessible(true);
                Object[] args = getArgumentsFor(method);
                System.out.println("--> Вызываем метод: " + method.getName() + " (" + times + " раз");

                try {
                    for(int i = 0; i < times; i++){
                        method.invoke(obj, args);
                    }
                } catch (Exception e){
                    System.out.println("Ошибка при вызове метода: " + e.getMessage());
                }
                System.out.println();
            }
        }
    }
    private static Object[] getArgumentsFor(Method method){
        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] args = new Object[paramTypes.length];

        for (int i = 0; i < paramTypes.length; i++){
            if (paramTypes[i] == String.class){
                args[i] = "Текстовый текст";
            } else if (paramTypes[i] == int.class) {
                args[i] = 25;
            }
        }
        return args;
    }
}
