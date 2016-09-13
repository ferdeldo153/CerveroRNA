/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA.Multilayer;

import RNA.Perceptron.Perceptron;

/**
 *
 * @author 3MEW
 */
public class Layer {
    Perceptron[] layer;
    /**
 * @param  nnet  neruronas por capa
  * @param  input  entradas esperadas de la capa
   * @param  output  salida esperada de la capa
    * @param  ft  funcion de trasferencia de la capa
     * @param  train  entrenamiento de la capa
 */
    public Layer(int nnet,double [][]input,double [] output,String ft,String train) {
        layer=new Perceptron[nnet];
        for(int x=0;x<nnet;x++){
            layer[x]=new Perceptron(input,output,ft,train);
        }        
    }
    /**
 * Returns an double realiza el resultado de la red
 * <p>
 * Este metodo regresa el resultado de la red
 *
 *
 * @param  in  Evalue evitando el casteo a arreglo
 * @return     El resultado la capa de red
 * @see         double
 */
    public double[] evaluateLayer(double []in){
        double[] output=new double[layer.length];
        for(int x=0;x<layer.length;x++){
         output[x]=layer[x].evaluatePerceptron(in);
        }
        return output;
    }
       /**
 * Entrena todas la neuronas de la capa
 */
    public void train(){
     for(int x=0;x<layer.length;x++)
         layer[x].train();
    }
  /**
 * Inicializa las iteraciones
* @param  iterations  indica el numero de iteraciones de entrenamiento
 */
    public void setIterations(int iterations) {
        for(int x=0;x<layer.length;x++)
            layer[x].train.setIterations(iterations);
    }
        /**
 * Inicializa el grado de error
 * @param  e  indica el error
 */
    public void setLM(double e) {
        for(int x=0;x<layer.length;x++)
            layer[x].train.setLM(e);
    }
       /**
 * cambia el entrenamiento de toda la capa
* @param  train  nombre del entramiento
 */
    public void setTainname(String train){
    for(int x=0;x<layer.length;x++){
         layer[x].setTrainname(train);
        }
    }
       /**
 * cambia el entrenamiento por neurona
* @param  x  indica que neurona
* @param  train  nombre del entrenamiento
 */
    public void setTainname(int x,String train){
         layer[x].setTrainname(train);
    }
          /**
 * cambia la funcion en toda la capa
* @param  a  nombre de funcion de tranferencia
 */
    public void setFxt(String a){
        for(int x=0;x<layer.length;x++){
         layer[x].setFxt(a);
        }
    }
      /**
 * Cambia la funcion por neurona
* @param  x  indica que neurona
* @param  a  nombre de funcion de tranferencia
 */
    public void setFxt(int x,String a){
         layer[x].setFxt(a);
    }  
/**
 * Regresa el tamaño de la capa
 */
    public int nnet(){
        return layer.length;
    }
    public void setWeight(int x,double []weight){
        layer[x].setWeight(weight);
    }
    public void  setBias(int x, double bias){
    layer[x].setBias(bias);
    }
    public void changeInput(double [][]input){
    for(int x=0;x<layer.length;x++)
         layer[x].train.setInput(input);
        }
   public void changeOutput(double []output){
    for(int x=0;x<layer.length;x++){
         layer[x].train.setOutput(output);
        }
    
    }
}
