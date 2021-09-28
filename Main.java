package com.company;
import java.io.PrintWriter;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// komi,razbor kaka nado


public class Main {

    public static void main(String[] args) {

        String csv_path = "src/com/company/testLab2.csv";
        String line = "";

        System.out.println("Write a delimiter : ");
        Scanner s = new Scanner(System.in);
        String delimiter = s.nextLine();


        try {

            PrintWriter pw = new PrintWriter("src/com/company/wtestLab2.csv");
            StringBuilder sb = new StringBuilder();


            try {
                BufferedReader br = new BufferedReader(new FileReader(csv_path));


                while((line = br.readLine()) != null){

                    String[] values = line.split(delimiter);
                    int c1 = 0;
                    int coma = 0;
                    int lengthv = 0;

                    for(String index : values){
                        if(index.contains("“") == true){


                            if(c1==0){
                                lengthv=0;
                            }

                            c1++;
                            coma++;

                            if(c1==2){
                                c1=0;
                                coma-=3;
                                lengthv+=coma;
                                coma=0;
                                lengthv+= index.length();
                                sb.append(lengthv);
                                sb.append("+");
                            }else{
                                lengthv = index.length();
                            }


                            System.out.printf("%-10s" ,index);
                            System.out.println(" "+ lengthv);



                        }else if(c1==1){
                            coma++;
                            lengthv+= index.length();
                            System.out.printf("%-10s" ,index);
                            System.out.println(" "+ lengthv);

                        }

                        else{

                            System.out.printf("%-10s" ,index);
                            System.out.println(" "+ index.length());
                            sb.append(index.length());
                            sb.append("+");


                        }

                    }


                    System.out.println();
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("\n");

                }

                pw.write(sb.toString());
                pw.close();





            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }


        }catch(FileNotFoundException e){
            System.out.println("pezda");
        }

    }







    public static void filewriter(int ch1slo){

    }


}























/**String[] values = line.split(",");

 for(String index : values){
 int lengthv = index.length();
 System.out.printf("%-10s" ,index);
 System.out.println(" "+ lengthv);
 }
 System.out.println();*/





/**for (int i=0;i<10;i++){
 String[] values = line.split(",");



 if (values[i] != null){
 int lengthv = values[i].length();
 System.out.println(values[i] +" "+ lengthv);
 }else{
 break;

 }

 }*/





//while((line = br.readLine()) != null){
//String[] values = line.split(",");
//int lengthv0 = values[0].length();
//System.out.println(values[0] +" " + lengthv0);
//int lengthv1 = values[1].length();
//System.out.println(values[1] +" " + lengthv1);
//int lengthv2 = values[2].length();
//System.out.println(values[2] +" " + lengthv2);
//}