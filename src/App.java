/*
* File: App.java
* Author: Sallai András
* Copyright: 2024, Sallai András
* Group: szit
* Date: 2024-12-15
* Github: https://github.com/oktat/
* Licenc: MIT
*/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
public static void main(String[] args) {
nevjegy();
//Fejrész kiírása
System.out.println("Jelszavak");
//Verzió kiírása
System.out.println("Verzió: 0.0.1");

//Az a objektummal kérhetünk be a konzolról
Scanner a = new Scanner(System.in);

System.out.print("Felhasználónév: ");
// A b változó tárolja a jelszót
String b = a.nextLine();
System.out.print("Jelszó: ");
String c = a.nextLine();
System.out.print("Hely: ");
String d = a.nextLine();
a.close();
int iSiker = 0;
try {
    /* 
    A jelszó, a felhasználónév és a 
    használati helye a passList 
    objektumban van tárolva            
    */
    Store passList = new Store(b, c, d);
    FileWriter f = new FileWriter("pass.txt");
    PrintWriter pwr = new PrintWriter(f);
    pwr.print(passList.a);
    if(!passList.hollow()) { pwr.print(passList.retrieval()); }
    pwr.print(passList.place);
    pwr.close();
    iSiker = 1;
} catch (IOException e) {
    System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
}

if(iSiker == 1) { System.out.println("Ok. A kiírás sikeres.");  }else {  System.out.println("Hiba! A kiírás sikertelen"); }

}

public static void nevjegy() {
System.out.println("Nagy János");
}
}
