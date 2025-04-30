package Infinite.MavenDemo;

import com.java.maven.Employ;

public class App {

  public static void main(String[] args) {
    Employ e = new Employ();
    e.setName("Ananta");
    e.setGender("Male");
    e.setDept("CSE");
    e.setBasic(45363);
    e.setEmpno(12);
    e.setDesig("Developer");
    
    System.out.println(e);
  }

}
