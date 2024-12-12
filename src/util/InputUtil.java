package util;

import java.util.Scanner;

public class InputUtil  {

    private static Scanner scanner = new Scanner(System.in);
    public static String inputS(String info){
        System.out.print(info +" : ");
        String data = scanner.nextLine();
        return data;
    }
    public static Integer inputI(String info){
        System.out.print(info + " : ");
        while(!scanner.hasNextInt()){
            System.out.println("Input harus berupa angka coba lagi.");
            System.out.println(info + ": ");
            scanner.nextInt();
        }

        return scanner.nextInt();
    }

}
