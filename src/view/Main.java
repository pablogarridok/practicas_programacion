package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pablogarrub
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funciones;

public class Main {
  static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String option="";
        do {
            try {
                System.out.println("\nTESTER FUNCIONES");
                System.out.println("1.- createFolder");
                System.out.println("2.- createFile");
                System.out.println("3.- showListFiles");
                System.out.println("4.- showFile");
                System.out.println("5.- overWriteFile");
                System.out.println("6.- deleteFile");
                System.out.println("7.- countChars");
                System.out.println("8.- countWords");
                System.out.println("9.- swapWords");
                System.out.println("10.- printPDF");
                System.out.println("X.- SALIR");
                
                System.out.println("Option: ");
                option = sc.next();
                
                switch (option) {
                    case "1":
                        createFolder();
                        break;
                    case "2":
                        createFile();
                        break;
                    case "3":
                        showListFiles();
                        break;
                    case "4":
                        showFile();
                        break;
                    case "5":
                        overWriteFile();
                        break;
                    case "6":
                        deleteFile();
                        break;
                    case "7":
                        countChars();
                        break;
                    case "8":
                        countWords();
                        break;
                    case "9":
                        swapWords();
                        break;
                    case "10":
                        printPDF();
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
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        } while ((!option.equals("X")) && (!option.equals("x")));
    }

    //====RUTA PARA LOS ARCHIVOS ==> src/ficheros  =====
        public static void createFolder() {
            System.out.println("Introduce el nombre de la carpeta que quieres crear: ");
            String nombreCarpeta= sc.next();
            Funciones.createFolder(nombreCarpeta);
        }

        public static void createFile() throws IOException {
            System.out.println("Introduce la ruta donde quieras guardar el archivo: ");
            String path= sc.next();
            System.out.println("\nIntroduce el nombre del archivo: ");
            String fileName= sc.next();
            System.out.println("\nIntroduce el contenido del archivo: ");
            String content = sc.next();
            
            Funciones.createFile(path, fileName, content);
        }

        public static void showListFiles() {
            System.out.println("Introduce la ruta del directorio el cual quieras ver el listado de archivos:");
            String path = sc.next();
            
            String[] listaArchivos = Funciones.showListFiles(path);
            if (listaArchivos.length == 0) {
                System.out.println("El directorio está vacío o no es válido.");
            }
            else {
                System.out.println("Archivos encontrados: ");
                for (String archivo: listaArchivos) {
                    System.out.println(archivo);
                }
            }
        }

        public static void showFile() throws FileNotFoundException {
            System.out.println("\nIntroduce la ruta donde se encuentra el archivo del que quieras ver el contenido");
            String path = sc.next();
            System.out.println("Introduce el nombre del archivo del que quieras ver el contenido");
            String fileName = sc.next();
            
            String content = Funciones.showFile(path, fileName);
            System.out.println(content);
            
        }

        public static void overWriteFile() throws IOException {
            System.out.println("\nIntroduce la ruta donde se encuentra el archivo del que quieras modificar el contenido");
            String path = sc.next();
            System.out.println("Introduce el nombre del archivo del que quieras modificar el contenido");
            String fileName = sc.next();
            System.out.println("Introduce el nuevo contenido del archivo previamente especificado: ");
            String newContent = sc.next();
            
            Funciones.overWriteFile(path, fileName, newContent);
        }

        public static void deleteFile() {
            System.out.println("\nIntroduce la ruta donde se encuentra el archivo eliminar");
            String path = sc.next();
            System.out.println("Introduce el nombre del archivo eliminar");
            String fileName = sc.next();
            Funciones.deleteFile(path, fileName);
        }

        public static void countChars() {
            System.out.println("\nIntroduce la ruta donde se encuentra el archivo del que quieres contar los caracteres");
            String path = sc.next();
            System.out.println("Introduce el nombre del archivo del que quieres contar los caracteres");
            String fileName = sc.next();
            
            int count= Funciones.countChars(path, fileName);
            if (count==0) {
                System.out.println("No se ha podido encontra el archivo especificado");
            }
            else{
                System.out.println("El archivo especificado tiene " + count + " caracteres");
            }
        }

        public static void countWords() throws FileNotFoundException {
            System.out.println("\nIntroduce la ruta donde se encuentra el archivo del que quieres contar las palabras");
            String path = sc.next();
            System.out.println("Introduce el nombre del archivo del que quieres contar las palabras");
            String fileName = sc.next();
            
            int count = Funciones.countWords(path, fileName);
            if (count==0) {
                System.out.println("No se ha podido encontra el archivo especificado");
            }
            else {
                System.out.println("El archivo especificado tiene " + count + " palabras");
            }
        }

        public static void swapWords() throws IOException {
            System.out.println("\nIntroduce la ruta donde se encuentra el archivo del que quieres cambiar las palabras");
            String path= sc.next();
            System.out.println("Introduce el nombre del archivo del que quieres cambiar las palabras");
            String fileName = sc.next();
            
            String content = Funciones.showFile(path, fileName);
            System.out.println("Este es el contenido del archivo que has especifiado: \n" + content);
                    
            System.out.println("Introduce la palabra que quieres sustituir");
            String oldWord = sc.next();
            System.out.println("Introduce la palabra por la que quiere sustituir la palabra anteriormente mencionada");
            String newWord = sc.next();
                    
            
            System.out.println("Este el contenido despues del cambio: \n" + Funciones.swapWords(path, fileName, oldWord, newWord));
            
            
        }

        public static void printPDF() {

        }
}
