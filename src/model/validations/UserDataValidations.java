/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author pablogarrub
 */
public class UserDataValidations {

    /**
     * Debe validar si el documetno identificativo recibido es correcto o no
     *
     * @param typeDoc indica el tipo de documento identificativo (NIF - 1,...)
     * @param id contiene el documento identificativo a validar
     * @return devuelve true si el formato del documento es correcto y false en
     * caso de que no sea correcto
     */
    public static boolean checkId(int typeDoc, String id) {
        boolean idOk = false;

        if (typeDoc == 1) {
            if (id.length() == 9) {
                String parteNumerica = id.substring(0, 8);
                String parteLetra = id.substring(8, 9);
                if (parteNumerica.matches("[0-9]{8}") && parteLetra.matches("[A-Za-z]")) {
                    idOk = true; // El id es válido
                }
            }
        }

        return idOk;
    }
    /**
     * Debe validar si el formato de la fecha recibida es correcto o no
     * 
     * @param date contiene la fecha a validar
     * @return devuelve true si el formato de la fecha es correcto y false en
     * caso de que no sea correcto
     */

    public static boolean checkFormatDate(String date) {
        boolean okFormatDate = false;
        if (date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            String[] dates = date.split("/");
            int day = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int year = Integer.parseInt(dates[2]);

            if (year <= 2025) {
                if (month > 0 && month < 13) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        if (day > 0 && day <= 31) {
                            okFormatDate = true;
                        }
                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        if (day > 0 && day <= 30) {
                            okFormatDate = true;
                        }
                    } else if (month == 2) {
                        if ((isLeapYear(year) && day <= 29) || (!isLeapYear(year) && day <= 28)) {
                            okFormatDate = true;
                        }
                    }
                }
            }

        }
        return okFormatDate;
    }

    /**
     * Debe validar si el año recibido es bisiesto
     * 
     * @param year contiene el año a validar
     * @return Devuelve true si el año es bisiesto y false si no lo es
     */
    public static boolean isLeapYear(int year) {
        boolean leapYear = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            leapYear = true;
        }
        return leapYear;
    }

    /**
     * Debe calcular la edad mediante una fecha recibida
     * 
     * @param birthDate contiene la fecha de nacimiento
     * @return En el caso de que el formato de la fecha de nacimiento sea correcto devuelve la edad, y en el caso de que no lo sea devuelve -1
     */
    public static int calculateAge(String birthDate) {
        boolean okFormatDate = UserDataValidations.checkFormatDate(birthDate);
        if (okFormatDate == true) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDateObj = LocalDate.parse(birthDate, formatter);
            LocalDate fechaActual = LocalDate.now();
            Period age = Period.between(birthDateObj, fechaActual);
            if (birthDateObj.isAfter(fechaActual)) {
                return -1;
            } else {
                return age.getYears();
            }

        } else {
            return -1;
        }
    }

    /**
     * Debe validar el formato de un codigo postal
     * 
     * @param zip es el codigo postal recibido
     * @return devuelve true en el caso de que el formato de codigo postal sea correcto y false en el caso de que no
     */
    public static boolean checkPostalCode(String zip) {
        boolean okPostalCode = false;
        if (zip.length() == 5) {
            if (zip.matches("[0-9]{5}")) {
                okPostalCode = true;
            }
        }

        return okPostalCode;
    }

    /**
     * Debe validar que el una cadena de caracteres sean numeros
     * 
     * @param str es la cadena de caracteres que tiene que validar que sean numeros 
     * @return devuelve true si son numeros y false si no lo son
     */
    public static boolean isNumeric(String str) {
        boolean isNumeric = false;
        if (str.matches("\\d+")) {
            isNumeric=true;
        }
        
        return isNumeric;
    }
    
    /**
     * Debe validar que el una cadena de caracteres sean letras
     * 
     * @param str es la cadena de caracteres que tiene que validar que sean letras
     * @return devuelve true si son letras y false si no lo son
     */
    public static boolean isAlphabetic(String str){
        boolean isAlphabetic=false;
        
        if (str.matches("^[a-zA-Z ]+$")) {
            isAlphabetic=true;
        }
        return isAlphabetic;
    }
    
    /**
     * Debe validar que formato de un email es correcto 
     * 
     * @param email es el email que tiene que validar
     * @return devuelve true si el formato es correcto y false si no lo es
     */
    public static boolean checkEmail(String email){
    boolean okEmail=false;
        if (email.contains("@")) {
            if ((email.endsWith(".com"))  || (email.endsWith(".es"))   || (email.endsWith(".net"))|| (email.endsWith(".org"))|| (email.endsWith(".cat"))|| (email.endsWith(".info"))) {
                okEmail=true;
            }
        }
    
    return okEmail;
    }
    
    /**
     * Debe validar que el nombre tenga solo letra y no numero y que tenga una longitud razonable
     * 
     * @param name es el nombre que tiene que validar
     * @return devuelve true el formato del nombre es correcto y false si no lo es
     */
    public static boolean checkName(String name){
    boolean nameOk=false;
    boolean isAlphabetic=UserDataValidations.isAlphabetic(name);
        if ((name.length()<100)&(isAlphabetic==true))  {
            nameOk=true;
        }
    return nameOk;
    }
    
}
