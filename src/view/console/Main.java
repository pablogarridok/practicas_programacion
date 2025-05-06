/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

/**
 *
 * @author pablogarrub
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String option;
        do {
            System.out.println("TESTER FUNCIONES UserdataValidations");
            System.out.println("1.- testCheckId");
            System.out.println("2.- testCheckFormatDate");
            System.out.println("3.- testCalculateAge");
            System.out.println("4.- testCheckPostalCode");
            System.out.println("5.- testIsNumeric");
            System.out.println("6.- testIsAlphabetic");
            System.out.println("7.- testCheckEmail");
            System.out.println("8.- testCheckName");
            System.out.println("X.- SALIR");

            System.out.println("Option: ");
            option = sc.next();

            switch (option) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testCheckFormatDate();
                    break;
                case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    testCheckName();
                    break;
                case "X":
                    System.out.println("Salir");
                    break;
                case "x":
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Incorrect option");

            }

        } while ((!option.equals("X")) && (!option.equals("x")));
    }

    public static void testCheckId() {
        System.out.println("Introduce tu NIF ");
        String nif = sc.next();
        boolean nifOk = UserDataValidations.checkId(1, nif);
        if (nifOk == true) {
            System.out.println("El NIF es correcto\n");
        } else {
            System.out.println("El formato del NIF no es correcto\n");
        }
    }

    public static void testCheckFormatDate() {
        System.out.println("Introuce la fecha (xx/xx/xxxx): ");
        String date = sc.next();
        boolean okFormatDate = UserDataValidations.checkFormatDate(date);
        if (okFormatDate == true) {
            System.out.println("El formato de la fecha es correcto\n");
        } else {
            System.out.println("El formato de de la fecha incorrecto\n");
        }

    }

    public static void testCalculateAge() {
        System.out.println("Introduce la fecha de tu dia de nacimiento (xx/xx/xxxx): ");
        String birthDate = sc.next();
        int age = UserDataValidations.calculateAge(birthDate);
        if (age == -1) {
            System.out.println("El formato de la fecha no es correcto o es posterior a la fecha actual\n");
        } else {
            System.out.println("Tienes " + age + " años\n");
        }
    }

    public static void testCheckPostalCode() {
        System.out.println("Introduce tu codigo postal: ");
        String postalCode = sc.next();
        boolean okPostalCode = UserDataValidations.checkPostalCode(postalCode);
        if (okPostalCode == true) {
            System.out.println("El formato de tu codigo postal es correcto\n");
        } else {
            System.out.println("El formato de tu codigo postal es incorrecto\n");
        }
    }

    public static void testIsNumeric() {
        System.out.println("Introduce un numero: ");
        String numero = sc.next();
        boolean okNumero = UserDataValidations.isNumeric(numero);
        if (okNumero == true) {
            System.out.println("Son numeros\n");
        } else if (okNumero == false) {
            System.out.println("Algun caracter de los que has introducido no es un numero\n");
        }
    }

    public static void testIsAlphabetic() {

        System.out.println("Introduce solo letras: ");
        String letras = sc.next();
        boolean isAlphabetic = UserDataValidations.isAlphabetic(letras);
        if (isAlphabetic == true) {
            System.out.println("Solo hay letras\n");
        } else if (isAlphabetic == false) {
            System.out.println("Algun cáracter de los que has introducido no es una letra\n");
        }
    }

    public static void testCheckEmail() {
        System.out.println("Introduce tu direccion email: ");
        String  email=sc.next();
        boolean emailOK=UserDataValidations.checkEmail(email);
        if (emailOK==true) {
            System.out.println("Tu Email es valido\n");
        }
        else if (emailOK==false) {
            System.out.println("El email que has introducido no es valido\n");
        }
    }

    public static void testCheckName() {
        System.out.println("Introduce tu nombre: ");
        String name=sc.next();
        boolean nameOk=UserDataValidations.checkName(name);
        if (nameOk==true) {
            System.out.println("El nombre es válido\n");
        }
        else if (nameOk==false) {
            System.out.println("El nombre no es válido\n");
        }
    }

}
