/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA.Perceptron;

import RNA.ExcepcionesRNA;
import RNA.FxTransferencia;
import RNA.UtilRNA;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3MEW
 */
public class TrainP {
    double [][] input={{0}};
    double []output={0};
    double []weight={0};
    double bias=0.0;
    String fx="hardlim";
 /**
 * Inicializa las entradas y lo deseado de la red neuronal
 *
 *
 * @param  input  indica la entrada de la red neuronal
 *@param  output  indica la salida  de la red neuronal
 */
    public TrainP(double [][] input,double []output) {
        this.input=input;
        this.output=output;
        this.weight=new double[input[0].length];
        for(int x=0;x<input[0].length;x++)
            weight[x]=0.0;
    }
  /**
 * Inicializa el entrenamiento
 *
 *
 * @param  entrada  indica que entrenamiento debe realizar
 */
   void startTrain(String trainname) throws ExcepcionesRNA {
        switch(trainname){
            case "traingrad":gradiente();return;
            case "trainWH":WidrowHoff();return;
            default:
                  throw new ExcepcionesRNA("train "+trainname+" is invalid");
        }
    }
    double lm=0.5;
   int iterations=50;
  /**
 * Realiza el entrenamiento de la red con gradiente decendente
 * con regla delta
 *
 *
 */
    public void gradiente(){
    for(int i=0;i<this.iterations;i++){
    
        for(int row=0;row<input.length;row++){
            double a=0.0;
            double t=output[row];
            try {a=UtilRNA.sumProducto(input[row], weight);} catch (ExcepcionesRNA ex) {Logger.getLogger(TrainP.class.getName()).log(Level.SEVERE, null, ex);return;}
            try {a=new FxTransferencia().getFxTrans(a+bias, fx);} catch (ExcepcionesRNA ex) {Logger.getLogger(TrainP.class.getName()).log(Level.SEVERE, null, ex);return;}
            double e=t-a;
            bias=bias+(2*lm)*e;
            try {
                weight=UtilRNA.sum(weight, UtilRNA.scala(input[row],(2*lm)*e));
            } catch (ExcepcionesRNA ex) {
                Logger.getLogger(TrainP.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        } 
    }    
    }
   /**
 * Realiza el entrenamiento de la red con gradiente decendente
 * con regla WidrowHoff para adaline
 * https://www.youtube.com/watch?v=GKkWg8izusk
 */
  public void WidrowHoff(){
     double escalar=1/(double)input.length;
     double [][] r =UtilRNA.producto(UtilRNA.add(input[0],1),UtilRNA.add(input[0],1));
     for(int row=1;row<input.length;row++){
             r=UtilRNA.sum(r,UtilRNA.producto(UtilRNA.add(input[row],1),UtilRNA.add(input[row],1)));
             }
     r=UtilRNA.scala(r,escalar);
     double[] h=UtilRNA.scala(UtilRNA.add(input[0],1),output[0]);
      for(int row=1;row<input.length;row++){
         try {
             h=UtilRNA.sum(h,UtilRNA.scala(UtilRNA.add(input[row],1),output[row]));
         } catch (ExcepcionesRNA ex) {
             Logger.getLogger(TrainP.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
    h=UtilRNA.scala(h,escalar);
    r=UtilRNA.matrizInversa(r);
   double[]x=UtilRNA.producto(r, h);
   // UtilRNA.show(x);
    for(int x1=0;x1<weight.length;x1++)
        weight[x1]=x[x1];
    bias=x[x.length-1];
    }
  /**
 * Inicializa las iteraciones
* @param  iterations  indica el numero de iteraciones de entrenamiento
 */
   public void setIterations(int iterations) {
        this.iterations = iterations;
    }
   /**
 * Inicializa el grado de error
 * @param  e  indica el error
 */
    public void setLM(double e) {
        this.lm = e;
    }
  /**
 * Regresa la matriz de entrada
 * @return    Regresa la matriz de entrada
 * @see         double[][]
 */
    public double[][] getInput() {
        return input;
    }
  /**
 * inicializa las entradas
  * @param  input  indica la entrada
 */
    public void setInput(double[][] input) {
        this.input = input;
        this.weight=new double[input[0].length];
        for(int x=0;x<input[0].length;x++)
            weight[x]=0.0;
    }
  /**
 * Regresa la matriz de salidas
 * @return    Regresa la matriz de salidas
 * @see         double[]
 */
    public double[] getOutput() {
        return output;
    }
 /**
 * inicializa las entradas
  * @param  output  indica las salidas
 */
    public void setOutput(double[] output) {
        this.output = output;
    }
  /**
 * Regresa la matriz de pesos
 * @return    Regresa la matriz de pesos
 * @see         double[]
 */
    public double[] getWeight() {
        return weight;
    }
 /**
 * inicializa las entradas
  * @param  weight  indica los pesos
 */
    public void setWeight(double[] weight) {
        this.weight = weight;
    }
  /**
 * Regresa el bias
 * @return    Regresa el bias
 * @see         double
 */
    public double getBias() {
        return bias;
    }
 /**
 * inicializa las entradas
  * @param  bias  indica el bias
 */
    public void setBias(double bias) {
        this.bias = bias;
    }
/**
 * inicializa las entradas
* @param  fx  indica que funcion de activacion usar
 */
   public void setFxTrans(String fx) {
        this.fx = fx;
    }
}
