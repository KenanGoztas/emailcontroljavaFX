package com.example.emailcontrol;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*gmail kuralları
ilk karakter harf yada rakam olmalı
harf rakam veya nokta olabilir
en az 6 en çok 30 karakter olabilir
 */
public class MailControl {
    private List<String> provider = Arrays.asList("gmail", "hotmail", "gmx", "outlook");
    //arrayList oluşturmaktan farkı nedir??
    private List<String> password = Arrays.asList("password", "1234", "şifre", "kenan");

    public static void main(String[] args) {
        MailControl m = new MailControl();
        while (true) {
            System.out.println("mailinizi giriniz");

            Scanner input = new Scanner(System.in);
            String control = input.nextLine();
            if (m.obMail(control)) {
                System.out.println("maildir.");
                break;
            } else
                System.out.println("mail değildir");

            System.out.println("password giriniz");
            String pass = input.nextLine();
            if (m.obPassword(pass)) {
                System.out.println("şifre doğru.");
                break;
            } else
                System.out.println("şifre yanlış");
        }

    }

    public boolean obMail(String str) {
        str = str.trim().toLowerCase(); //boşluğunu aldım ve büyük harfleri küçülttüm.
        if (!str.contains("@") || str.charAt(0) == '@' || str.charAt(0) == '.' || str.contains(" ")) {
            System.out.println("@ karakteri ilk harf veya eksik, nokta ilk harf veya boşluk var");
            return false;
        }
        String[] s = str.split("@");
        String önkelime = s[0];
        String sonkelime = "@" + s[1];


        if ((önkelime.length() < 6 || önkelime.length() > 30)) {
            System.out.println("@ karakterinden önceki karakter 6-30 arasında olmalı");
            return false;
        }

        for (int i = 0; i < önkelime.length(); i++) {
            if ((önkelime.charAt(i) >= 97 && önkelime.charAt(i) <= 122) || (önkelime.charAt(i) >= 48 && önkelime.charAt(i) <= 57) || önkelime.contains(".")) {   //harfler
            } else
                return false;
        }
        for (String str1 : provider) {
            String mail = "@" + str1 + ".com";
            if (sonkelime.equals(mail)) {
                return true;
            }
        }
        return false;
    }

    public boolean obPassword(String pas) {
        for (String s : password) {
            if (pas.equals(s))
                return true;
        }
        return false;
    }
}



