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
public class FxActivacion {
        /**
 * Returns an double realiza la funcion de activación
 * <p>
 * Este metodo regresa el resultado de la funcion de activacion
 *
 *
 * @param  input  indica la entrada de la red neuronal
 *@param  weight  indica los pesos de la red neuronal
 *@param  bias  indica el bias de la red neuronal
 * @return     El resultado de la funcion de activacion
 * @see         double
 */
    public double accion(double[] input,double[] weight,double bias) throws ExcepcionesRNA{
    double a=0.0;
    if(input.length!=weight.length)
    throw new ExcepcionesRNA("input size:"+input.length+" weight size:"+weight.length+" ");
    else{
        for(int x=0;x<input.length;x++){
             a+=(input[x]*weight[x]);
        }
    }
    //System.out.println("activacion:"+(a+bias));
    return a+bias;
    }

}
