package com.example.basicjava;

public class StudentClass_Challange12 {
    private String name ;
    private int[] grades;

    public StudentClass_Challange12(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }


}

