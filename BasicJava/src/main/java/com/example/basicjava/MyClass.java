package com.example.basicjava;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello World!");

//        Challange11
//        creating an account

        Challange11 account1 = new Challange11("Natan haham", 1000.0);

//        depositing and withdrawing

        account1.deposit(500.0);
        account1.withdraw(200.0);

//      printing the account

        System.out.println("Account balance: " + account1.ballance);
        System.out.println("Account owner: " + account1.ownerName);
        System.out.println("Account balance: " + account1.getBalance());

//      Challange13
//        creating shapes

        CircleSubClass circle = new CircleSubClass(5.0);
        RectangelSubClass rectangle = new RectangelSubClass(4.0, 5.0);
        TriangleSubClass triangle = new TriangleSubClass(3.0, 4.0);

//      creating an array of shapes and areas

        String[] shapes = {circle.name(), rectangle.name(), triangle.name()};
        double[] areas = {circle.area(), rectangle.area(), triangle.area()};

//      printing the shapes and areas
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape Name "+ shapes[i]);
            System.out.println("Shape Area "+ areas[i]);
        }
    }
}