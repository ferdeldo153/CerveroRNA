/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

/**
 *
 * @author 3MEW
 */
public class FxTransferencia {
/**
 * Returns an double realiza la funcion de trasferencia  
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * por medio de su nombre.
 *
 * @param  a  Es el producto de la integral en la funcion de activacion
 * @param  fx indica que funcion de transferencia va utilizar
 * @return     El resultado de la neurona
 * @see         double
 */
    public  double getFxTrans(double a,String fx) throws ExcepcionesRNA{
     switch(fx){
         case "hardlim": return hardlim(a);
         case "hardlims":return hardlims(a);
         case "pureline":return pureline(a);
         case "logsig":return logsig(a);
         case "tansig":return tansig(a);
         case "satlin":return satlin(a);
         case "satlins":return satlins(a);
         case "poslin":return poslin(a);
         default:
             throw new ExcepcionesRNA(fx+" is invalid");
     }
    }
    /**
 * Returns an double realiza la funcion de trasferencia hardlim 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * hardlim
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
    public double hardlim(double n){
    if(n>=0)return 1.0;
    return 0.0;
    }
        /**
 * Returns an double realiza la funcion de trasferencia hardlims 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * hardlims
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
    public double hardlims(double n){
    if(n>=0)return 1.0;
    return -1.0;
    }
        /**
 * Returns an double realiza la funcion de trasferencia pureline 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * pureline
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
    public double pureline(double n){
    return n;
    }
        /**
 * Returns an double realiza la funcion de trasferencia satlins 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * satlin
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
    public double satlin(double n){
    if(n<0)return 0.0;
    if(n>=0&&n<=1)return n;
    return 1;
    }
  /**
 * Returns an double realiza la funcion de trasferencia satlins 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * satlins
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
   public double satlins(double n){
    if(n<-1)return -1;
    if(n>=-1&&n<=1)return n;
    return 1;
    }
          /**
 * Returns an double realiza la funcion de trasferencia logsig 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * logsig
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
    public double logsig(double n){
     return 1.0 / (1 + Math.exp(-n)); 
    }
            /**
 * Returns an double realiza la funcion de trasferencia tansig 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * tansig
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
    public double tansig(double n){
    return Math.tanh(n);
    }
          /**
 * Returns an double realiza la funcion de trasferencia poslin 
 * <p>
 * Este metodo regresa el resultado de la funcion de trasferencia
 * poslin
 *
 * @param  n  Es el producto de la integral en la funcion de trasferencia
 * @return     El resultado de la neurona
 * @see         double
 */
   public double poslin(double n){
    if(n<0)return 0.0;
    return n;
    }
}
