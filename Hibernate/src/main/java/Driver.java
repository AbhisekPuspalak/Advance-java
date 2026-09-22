import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Driver {
    private  static  EntityManagerFactory emf;
    private  static  EntityManager em;
    private  static  EntityTransaction et;
    private  static  Scanner sc;
    static {
        emf = Persistence.createEntityManagerFactory("HND");
        em = emf.createEntityManager();
        et = em.getTransaction();
        sc=new Scanner(System.in);
    }
    public static void main(String[] args) {

//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("HND");
//        EntityManager em=emf.createEntityManager();
//        EntityTransaction et=em.getTransaction();
//        Scanner sc =new Scanner(System.in);
        int choice=0;
//
//        Student s1=new Student(102,"krish","Java Fullstack");
//        et.begin();
//        em.persist(s1);
//        em.merge(s1);
//        et.commit();

        do{
            System.out.println("1.Add Student\n2.Update the Student\n3.Find By Id\n4.Delete the Student");
            choice=sc.nextInt();
            switch(choice){
                case 1:Student st=new Student();
                System.out.println("Enter Student ID");
                st.setId(sc.nextInt());
                System.out.println("Enter Student Name");
                st.setName(sc.nextLine());
                st.setName(sc.nextLine());
                System.out.println("Enter Student course");
                st.setCourse(sc.nextLine());
                add(st);
                break;
                case 2:
                    Student st1=new Student();
                    System.out.println("Enter the Id you want to Update");
                    int id=sc.nextInt();
                    Update(id);
                    break;
//                case 3:find();
//                break;
//                case 4:delete();
//                break;
            }
        }while(choice!=0);
    }

    private static boolean add(Student st){
        if(st!=null){
            et.begin();
            em.persist(st);
            et.commit();
            return true;
        }
        return  false;
    }
    private static String Update(int id){
//        Student std=em.find(Student.class,st.getId());
        Student std=em.find(Student.class,id);
        if(std!=null){
            System.out.println("Enter the course you want to update");
            sc.nextLine();
            std.setCourse(sc.nextLine());
            System.out.println("Enter the new name");
            std.setName(sc.nextLine());
            et.begin();
            em.merge(std);
            et.commit();
            return "Success";
        }else{
            return "Student not found";
        }
    }
//    private static boolean find(){
//        return  true;
//    }
//    private static boolean delete(){
//        return  true;
//    }
}
