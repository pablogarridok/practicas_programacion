/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pablogarrub
 */
public class Funciones {

    /**
     * @param args the command line arguments
     */
    
Scanner sc = new Scanner(System.in);    
    
    /**
     * Crea una carpeta con el nombre que le especifique el usuario (solo la crea si la carpeta no existe)
     * 
     * @param fileName contiene el nombre de la carpeta a crear 
     */    
    public static void createFolder(String fileName){
        
        String ruta = System.getProperty("user.dir");
        String separador= File.separator;
        String rutaCarpeta= ruta + separador +fileName;
        File carpeta = new File(rutaCarpeta);
        
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("La carpeta " + fileName + " se ha creado exitosamente\n");
        }
        else {
            System.out.println("Ya hay una carpeta con ese nombre\n");
        }
    }
    
    /**
     * Crea un archivo con el nombre y en la ruta que le especifique el usuario.Si previamente no existe un fichero con este nombre se creara, si existe se añadira el nuevo contenido
     * 
     * @param path contiene la ruta en la que se guardara el archivo 
     * @param fileName contiene el nombre del archivo 
     * @param content contiene el contenido que se añadira al archivo creado
     * @throws IOException 
     */
    
    public static void createFile(String path, String fileName, String content) throws IOException{
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        
        String file= path + fileName + ".txt";
        
        FileWriter fw = new FileWriter(file, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("");
        
        bw.write(content);
        
        bw.flush();
        
        bw.close();
        System.out.println("Se ha creado el archivo en la ruta especificado");
    }
    
    /**
     * 
     * Devuelve una lista de los archivos que contiene la ruta que le especifique el usuario
     * 
     * @param path contiene la ruta de la que se tiene que devolver la lista de archivos
     * @return 
     */
    public static  String[] showListFiles(String path){
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        
        File carpeta = new File(path);
        
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] listaArchivos = carpeta.listFiles();
            
            if (listaArchivos !=null) {
                String[] nombreArchivo = new String[listaArchivos.length];
                for (int i = 0; i < listaArchivos.length; i++) {
                    nombreArchivo[i] = listaArchivos[i].getName();
                }
                return nombreArchivo;
            }
        }
        return new String[0];
    } 
    
    /**
     * devuelve el contenido del archivo que el eusuario dentro dentro de la ruta, que también especifica el usuario
     * 
     * @param path contiene la ruta en la que se localizara el archivo
     * @param fileName contiene el nombre del archivo del que se devolvera el contenido
     * @return
     * @throws FileNotFoundException 
     */
    public static String showFile(String path, String fileName) throws FileNotFoundException{
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        
        String finalPath = path + fileName;
        File fichero = new File (finalPath);
        
        
        Scanner in = new Scanner(fichero);
        String line="";
        
        while (in.hasNextLine()){
            line += in.nextLine()+"\n";
        }
       
        in.close(); 
        return line;
    }
    
    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException{
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        String finalPath = path + fileName;
        File file = new File(finalPath);
        if (file.exists()) {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newContent);
            bw.close();
            
            System.out.println("El contenido del archivo se ha sobreescrito correctamente\n");

            return true;
        }
        else{
            System.out.println("No se ha sobreescrito el archivo porque el archivo especificado no existe\n");

            return false;
        }
    }
    
    public static void deleteFile(String path, String fileName){
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        
        String finalPath = path + fileName;
        File file = new File(finalPath);
        if (file.exists()) {
            file.delete();
            System.out.println("El fichero especificado se ha eliminado correctamente");
        }
        else{
            System.out.println("No se ha encontrado el archivo especofocado");
        }
    }
    
    public static int countChars(String path, String fileName)  {
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        String finalPath = path + fileName;

        File file = new File(finalPath);
        int count = 0;

        if (file.exists()) {
            try (FileReader fr = new FileReader(file)) {
                int character;
                while ((character = fr.read()) != -1) {
                    count++;
                }
            } 
            catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } 
        else {
            count = 0;
        }

        return count;
    }
    
    public static int countWords(String path, String fileName) throws FileNotFoundException{
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        String finalPath = path + fileName;
        File file = new File(finalPath);
        int count= 0;
        
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.trim().split("\\s+");//separa por un o mas deunespacio
                    count += words.length;
                }
            } 
            catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } 
        else {
        count = 0;
        }
        
        return count;
    }
    
    public static String swapWords(String path, String fileName, String oldWord, String newWord) throws FileNotFoundException, IOException {
        if (!path.endsWith(File.separator)) {
            path += File.separator;
        }
        String finalPath = path + fileName;
        StringBuilder content = new StringBuilder();
        File file = new File(finalPath);
        
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
            catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
            }   
            String updatedContent = content.toString().replace(oldWord, newWord);
            return updatedContent;
        } 
        else {
            return "No se ha encontrado el archivo especificado";
        }
    }
    
}
