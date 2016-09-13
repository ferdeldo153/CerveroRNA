/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA.Perceptron;

import RNA.ExcepcionesRNA;
import RNA.FxActivacion;
import RNA.FxTransferencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 3MEW
 */
public class Perceptron {

    double[] weight={0};
    double bias=0.0;
    String fxt="hardlim";
    public TrainP train;
    String trainname="traingrad";
    public Perceptron() {
    }
     /**
 * Este metodo inicializa los datos del entrenamiento 
 *
 *
 * @param  ft indica la funcion de transferencia
 *@param  input  indica las entradas
 *@param  output  indica lo deseado
 *@param  train  indica el entrenamiento
 */
    public Perceptron(double [][] input,double []output,String ft,String train) {
        this(input,output, ft);
     this.trainname=train;
    }
  /**
 * Este metodo inicializa los datos del entrenamiento con entrenamiento de gradiente decendente
 *
 *
 * @param  ft indica la funcion de transferencia
 *@param  input  indica las entradas
 *@param  output  indica lo deseado
 */
   public Perceptron(double [][] input,double []output,String ft) {
  if(input.length!=output.length)
    try {
        throw new ExcepcionesRNA("input size:"+input.length+" output size:"+output.length+" ");
  } catch (ExcepcionesRNA ex) {
      Logger.getLogger(Perceptron.class.getName()).log(Level.SEVERE, null, ex);
  }
  this.fxt=ft;
     this.train=new TrainP(input,output);
     this.train.setFxTrans(ft);
    }
  /**
 * Este metodo inicia el entrenamiento
 */
   public void train(){
        try {
            train.startTrain(this.trainname);
        } catch (ExcepcionesRNA ex) {
            Logger.getLogger(Perceptron.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.bias=train.getBias();
       this.weight=train.getWeight();
   }
 /**
 * Este metodo regresa el resultado de la funcion de activacion
 *
 *
 * @param  fxtras  indica la funcion de transferencia
 *@param  weight  indica los pesos de la red neuronal
 *@param  bias  indica el bias de la red neuronal
 */
    public Perceptron(double[] weight,double bias,String fxtras) {
        this.weight=weight;
        this.bias=bias;
        this.fxt=fxtras;
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
 * Regresa el bias
 * @return    Regresa el bias
 * @see         double
 */
    public double getBias() {
        return bias;
    }
  /**
 * Regresa nombre de la funcion de trasferencia
 * @return    Regresa nombre de la funcion de trasferencia
 * @see         String
 */
    public String getFxt() {
        return fxt;
    }
   /**
 * inicializa  los pesos
  * @param  a  indica los pesos
 */
    public void setWeight(double[] a) {
        this.weight=a;
    }
   /**
 * inicializa  el bias
  * @param  a  indica el bias
 */
    public void setBias(double a) {
        this.bias=a;
    }
   /**
 * manda la funcion de traferencia
  * @param  a  manda la funcion de traferencia
 */
    public void setFxt(String a) {
        this.fxt=a;
    }
         /**
 * Returns an double realiza el resultado de la red
 * <p>
 * Este metodo regresa el resultado de la red
 *
 *
 * @param  input  indica la entrada de la red neuronal a evaluar
 * @return     El resultado de la red
 * @see         double
 */
  public double evaluatePerceptron(double[] input){
        double output=0.0;
        try {
     FxActivacion fa=new FxActivacion();
     FxTransferencia ft=new FxTransferencia();
     output= ft.getFxTrans(fa.accion(input, weight, bias), fxt);
        } catch (ExcepcionesRNA ex) {
            Logger.getLogger(Perceptron.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
 /**
 * Returns an double realiza el resultado de la red
 * <p>
 * Este metodo regresa el resultado de la red
 *
 *
 * @param  in  Evalue evitando el casteo a arreglo
 * @return     El resultado de la red
 * @see         double
 */
    public double evaluatePerceptron(double in){
        double[] input={in};
        double output=0.0;
        try {
     FxActivacion fa=new FxActivacion();
     FxTransferencia ft=new FxTransferencia();
     output= ft.getFxTrans(fa.accion(input, weight, bias), fxt);
        } catch (ExcepcionesRNA ex) {
            Logger.getLogger(Perceptron.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
     /**
 * Regresa el entrenamiento
 * @return    El entrenamiento
 * @see         TrainP
 */ 
   public TrainP getTrain() {
        return train;
    }
   /**
 *  entrenamiento
  * @param  train   entrenamiento
 */
    public void setTrain(TrainP train) {
        this.train = train;
    }
  /**
 * Regresa nombre del entrenamiento
 * @return    Regresa nombre del entrenamiento
 * @see         String
 */
    public String getTrainname() {
        return trainname;
    }
   /**
 * inicializa  el nombre del entrenamiento
  * @param  trainname  nombre del entrenamiento
 */
    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }
  /**
 * Guarda los pesos del perceptron
  * @param  guarda  recibe un File donde guardara los pesos
 */
    public void save(File guarda) {
        try {
            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda);
                String txt=""+this.getFxt()+"\n";
                for(int x=0;x<weight.length;x++)
                    txt+=""+weight[x]+";";
                txt+="\n"+bias;
                save.write(txt);
                save.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
 /**
 * carga los pesos del perceptron
  * @param  guarda  recibe un File donde carga los pesos
 */
    public void load(File guarda) {
        int indi=0;
        try {
            if (guarda != null) {
                FileReader archivos = new FileReader(guarda);
                BufferedReader lee = new BufferedReader(archivos);
                String aux;
                while ((aux = lee.readLine()) != null) {
                    
                    if(indi==0){
                        this.fxt=aux;
                        indi=1;
                    }
                    else if(indi==1){
                    StringTokenizer st = new StringTokenizer(aux, ";" ,true);
                    LinkedList au = new LinkedList();
                    while (st.hasMoreTokens()) {// limpia la cadena quitando tokens
                        String aux1 = st.nextToken();
                        if (!(aux1.equals(";"))) {
                          au.add(aux1);
                        }
                    }
                    weight=new double [au.size()] ;
                        for(int w=0;w<au.size();w++)
                        weight[w]=Double.parseDouble((String) au.get(w));
                        indi=2;
                    }
                    else if(indi==2) {
                     bias=Double.parseDouble(aux);
                    lee.close();
                    return;
                    }
            
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
