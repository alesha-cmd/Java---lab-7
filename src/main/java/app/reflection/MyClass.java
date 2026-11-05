package main.java.app.reflection;

public class MyClass {
    public void publicMethod1(){
        System.out.println("Вызван метод piblicMethod1()");
    }

    public void publicMethod2(String text){
        System.out.println("Вызван publicMethod2() с текстом: " + text);
    }

    @Repeat(times = 2)
    protected void protectedMethod1(){
        System.out.println(" [Protected] Вызван protectedMethod1()");
    }

    @Repeat(times = 3)
    protected void protectedMethod2(int number){
        System.out.println(" [Protected] Вызван protectedMethod2() с числом: " + number);
    }

    @Repeat(times = 2)
    private void privateMethod1(String message){
        System.out.println(" [Private] Вызван privateMethod1(): " + message);
    }

    @Repeat(times = 3)
    private void privateMethod2(String name, int age){
        System.out.println(" [Private] Вызван privateMethod2(): Имя = " + name + " , Возраст = " + age);
    }
}
