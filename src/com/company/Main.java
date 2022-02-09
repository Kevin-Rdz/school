package com.company;

//modificadores de acceso ----> Encapsulamiento

class Student{
    private String name;
    private String lastName;
    private String code;

    //Getters
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public String getCode(){
        return code;
    }
    public Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }
}
class Group{
    private String code;
    private Student[] students;
    private int enrolled;
    private int rejected;
    private int i;
    public String getCode(){
        return code;
    }
    public boolean addStudent(Student student){
        if (enrolled < students.length) {
            students[this.enrolled++] = student;
            return true;
        } else {
            ++this.rejected;
            return false;
        }
    }

    public int getEnrolled(){
        return enrolled;
    }
    public int getRejected(){
        return rejected;
    }
    public Student getStudent(int index){
        return students[index];
    }
    public void removeStudent(String code){
        for( i=0; i<enrolled ;i++) {
            if(students[i].getCode().equals(code))
                students[i] = students[i+1];
            enrolled--;
        }
    }
    public Group(String code, int capacity){
        this.code = code;
        students = new Student[capacity];
    }
}
public class Main {

    public static void main(String[] args) {
        Student student1; // Referencia a un Alumno
        Student student2 = new Student("Ivan", "Uresti", "972196");
        student1 = new Student("José", "González", "456789"); // Creando un objeto alumno

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);

        if (!group.addStudent(student1)) {
            System.out.println("Estudiante no fue añadido: " + student1.getName() + " " + student1.getLastName());
        }

        if (!group.addStudent(student2)) {

        }

        group.addStudent(new Student("Jorge", "Acosta", "1"));
        group.addStudent(new Student("Arturo", "Aleman", "2"));
        group.addStudent(new Student("Antonio", "Angel", "3"));
        group.addStudent(new Student("Francisco", "Arreguin", "4"));
        group2.addStudent(new Student("Misael", "Cabrera", "5"));
        group2.addStudent(new Student("Roberto", "Cisneros", "6"));
        group.addStudent(new Student("Juan", "Coronado", "7"));
        group.addStudent(new Student("José", "González", "8"));
        group.addStudent(new Student("Jesús", "Lara", "9"));
        group.addStudent(new Student("José", "Limón", "10"));

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        System.out.println();
        System.out.println("Alumnos del grupo: " + group.getCode());

        for (int i = 0; i < group.getEnrolled(); i++) {
            Student student = group.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

        System.out.println();
        System.out.println("Alumnos del grupo: " + group2.getCode());

        for (int i = 0; i < group2.getEnrolled(); i++) {
            Student student = group2.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

    }
}