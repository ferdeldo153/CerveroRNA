/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

import RNA.Multilayer.Multilayer;
import java.util.Arrays;


/**
 *
 * @author 3MEW
 */
public class CerveroRNA {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {

double [][] input ={
                   {0,0},
                   {1,0},
                   {0,1},
                   {1,1}
};
double [] output ={0,0,0,1};
int [] layer ={200,500,1};
String [] fx ={"logsig","logsig","hardlim"};
Multilayer xor=new Multilayer(layer,fx,input,output,"traingrad");
xor.setIterations(100);
xor.train();
for(int x=0;x<input.length;x++)
System.out.println("entrada"+Arrays.toString(input[x])+"Salida"+Arrays.toString(xor.evaluateMultiLayer(input[x])));
    }
    
}
