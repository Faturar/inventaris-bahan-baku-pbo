package util;

import java.util.Scanner;

public class InputUtil  {

    private static Scanner scanner = new Scanner(System.in);
    public static String inputS(String info){
        System.out.print(info +" : ");
        String data = scanner.nextLine();
        return data;
    }
    public static Integer inputI(int angka){
        Integer data = scanner.nextInt();
        return data;
    }

}
