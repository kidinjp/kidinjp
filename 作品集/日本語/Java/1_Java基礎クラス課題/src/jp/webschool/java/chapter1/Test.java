package jp.webschool.java.chapter1;

public class Test {
    public static void main(String[] args) {
        int a = 3;
        switch (a) {
            case 1:
                System.out.print("A");
            case 2:
                System.out.print("B");
                break;
            case 3:
                System.out.print("C");
            case 4:
                System.out.print("D");
            default:
                System.out.print("E");
        }
        System.out.print("F");

        
    }
}