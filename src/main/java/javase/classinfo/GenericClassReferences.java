package javase.classinfo;//: typeinfo/GenericClassReferences.java

public class GenericClassReferences {
  public static void main(String[] args) {
    Class intClass = int.class;
    Class<Integer> genericIntClass = int.class;
    genericIntClass = Integer.class; // Same thing
    intClass = double.class;
    System.out.println(intClass==genericIntClass);
    // genericIntClass = double.class; // Illegal

    Double a=new Double(12);
    Double b=new Double(13);

    System.out.println(intClass.equals(genericIntClass));
    System.out.println(a.getClass()==b.getClass());
  }
} ///:~
