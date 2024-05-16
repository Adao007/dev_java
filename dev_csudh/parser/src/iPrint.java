


import java.io.*;
import java.util.*;


//***************************************************************************
//     iPrint
//    Java code for indentation printing 
//***************************************************************************

class iPrint {
   static String tab ="\t";
   static boolean NOPRINT = false;
   static boolean showlevel = false;
   static int level = 0;            // indentation level

   public static void setIndentValue(String value){tab=value;} 

   //    printout user info but kepp track of indentation level
   //    'amount' could be -1, 0 , or 1   -1 decrements indetation level
   //                                      1 increamants indetation
   //    'str' is string to print
   public static void aprintln(int amount, String str, Boolean printit){
        aprint(amount,str+"\n", printit);
   }
   public static void aprint(int amount, String str, Boolean printit){
      level += amount;
      if(printit)
         for(int i=0; i<level; i++){
            if(!NOPRINT) System.out.print(tab);
         }
      if(printit) {       // show parsing info in detail
         if(!NOPRINT) System.out.print(str);
      }
   }
   public static void aprintln(int amount, String str){ 
       aprint(amount, str+"\n"); 
   }
   public static void aprint(int amount, String str){
       aprint(amount, str, true);
   }
   public static void aprintln(String str){
       aprint(str+"\n");
   }
   public static void aprint(String str){
       aprint(0,str,true);
   }


   public static void println(int amount, String str, Boolean printit){
        print(amount,str+"\n", printit);
   }
   public static void print(int amount, String str, Boolean printit){
      level += amount;
      if(printit)
         for(int i=0; i<level; i++){
            if(!NOPRINT) System.err.print(tab);
         }
      if(printit) {       // show parsing info in detail
         //if(showlevel) 
         //    if(!NOPRINT)  
         //        System.out.print(""+level+": ");
         if(!NOPRINT)System.err.print(str);
      }
   }

   public static void println(int amount, String str){ 
       print(amount, str+"\n"); 
   }
   public static void print(int amount, String str){
        print(amount, str, true);
   }
   public static void println(String str){
       print(str+"\n");
   }
   public static void print(String str){
         print(0,str,true);
   }

   public static void indentlevel(int amount){
      level += amount;
   }

   public static int getLevel(){ return level; }
   public static void zeroLevel(){ level = 0; }
   public static void noprint(){ NOPRINT = true; }
   public static void yesprint(){ NOPRINT = false; }
   public static void showLevel(){ showlevel = true; }
   public static void noLevel(){ showlevel = false; }
   public static void noShowLevel(){ showlevel = false; }
   
}
