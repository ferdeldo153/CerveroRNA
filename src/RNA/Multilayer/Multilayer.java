/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA.Multilayer;

import java.util.Arrays;

/**
 *
 * @author 3MEW
 */
public class Multilayer {
    Layer[] layer;
    double [][]input;
    double []output;
    public Multilayer(int[] nlayer,String []fx,double [][]input,double []output,String train) {
        this.input=input;
        this.output=output;
       layer= new Layer[nlayer.length];
       for(int x=0;x<layer.length;x++){
       layer[x]= new Layer(nlayer[x],input,output,fx[x],train);
       }  
    }
    public void train(){
       Layer aux= layer[0];
       double [][] inputaux =this.input;
       for(int x=1;x<layer.length;x++){
           aux.train();
        double [][] input2 =new double[inputaux.length][aux.nnet()];
           for(int y=0;y<inputaux.length;y++){
              input2[y]=aux.evaluateLayer(inputaux[y]);
            }
           layer[x].changeInput(input2);
           aux=layer[x];
           inputaux=input2;
           // System.out.println("x"+x+"in"+Arrays.toString(input2[0]));
       }
        
    }
     public double[] evaluateMultiLayer(double []in){
        double[] output;
        for(int x=0;x<layer.length;x++){
             layer[x].train();
         in=layer[x].evaluateLayer(in);
        }
        output=in;
        return output;
    }
    /**
 * Inicializa las iteraciones
* @param  iterations  indica el numero de iteraciones de entrenamiento
 */
    public void setIterations(int iterations) {
        for(int x=0;x<layer.length;x++)
            layer[x].setIterations(iterations);
    }
        /**
 * Inicializa el grado de error
 * @param  e  indica el error
 */
    public void setLM(double e) {
        for(int x=0;x<layer.length;x++)
            layer[x].setLM(e);
    }  
  
}
