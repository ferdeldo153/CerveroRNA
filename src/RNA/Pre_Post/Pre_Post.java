/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA.Pre_Post;


/**
 *
 * @author 3MEW
 */
public class Pre_Post {
    double rangmin=0.0;
    double rangomax=1.0;
    double min;
    double max;
        /**
 * <p>
 * inicializa el rango del escalmiento por default usa como minimi 0 y maximo 1
 *
 *
 * @param  rmin  indica la entrada de la red neuronal
 *@param  rmax  indica los pesos de la red neuronal
 */
    public Pre_Post(double rmin,double rmax) {
        this.rangmin=rmin;
        this.rangomax=rmax;
    }

    public Pre_Post() {
   this.rangmin=0.0;
   this.rangomax=1.0;
    }
 /**
 * Este metodo regresa el minimo
 *
 *
 * @param  input  matriz que busca el minimo
 */
    public void Minimo(double[][] input){
       this.min=input[0][0];
       for(int x=0;x<input.length;x++)
           for(int y=0;y<input[0].length;y++){
               if(this.min>=input[x][y])
                   this.min=input[x][y];
           }
    }
 /**
 * Este metodo regresa el maxima
 *
 *
 * @param  input  matriz que busca el maximo
 */
    public void Maximo(double[][] input){
       this.max=input[0][0];
       for(int x=0;x<input.length;x++)
           for(int y=0;y<input[0].length;y++){
               if(this.max<=input[x][y])
                   this.max=input[x][y];
           }
    }
 /**
 * Returns an double[][] el preprocesamiento
 * <p>
 * Este metodo realiza el preprocesamiento
 *
 *
 * @param  input  indica la entrada de la red neuronal
 * @return    regresa la matriz preprocesada
 * @see         double[][]
 */ 
   public double[][] Pre(double[][] input){
       double[][] in=new double[input.length][input[0].length];
       Maximo(input);
       Minimo(input);
        for(int x=0;x<input.length;x++){
           for(int y=0;y<input[0].length;y++){
               double a=(rangomax-rangmin)*(input[x][y]-min);
                double b=max-min;
                in[x][y]=((a/b)-Math.abs(rangmin));
           }
        }
       
     return in;
   }
         /**
 * Returns an double minimo de la matrz
 * <p>
 * Este metodo regresa el minimo
 *
 *
 * @return     Regresa el minimo
 * @see         double
 */
   public double getMin() {
        return min;
    }
        /**
 * Returns an double maximo de la matrz
 * <p>
 * Este metodo regresa el maximo
 *
 *
 * @return     Regresa el maximo
 * @see         double
 */
    public double getMax() {
        return max;
    }


}
