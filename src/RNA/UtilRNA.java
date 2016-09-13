/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RNA;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mew
 */
public class UtilRNA {
        /**
 * Este metodo imprime una matrz
 *
 *
 * @param  input  matriz que imprime
 */
    public static void show(double[][] input){
    for(int x=0;x<input.length;x++){
        String a="";
           for(int y=0;y<input[0].length;y++){
              a+=input[x][y]+" ";
           }
           System.out.println(a);
    }
}
        /**
 * Este metodo imprime una vector
 *
 *
 * @param  input  vector que imprime
 */
    public static void show(double[] input){
        String a="";
           for(int y=0;y<input.length;y++){
              a+=input[y]+" ";
           }
           System.out.println(a);
    
}
             /**
 * Returns an double realiza la sumatoria de la  integral
 * <p>
 * Este metodo regresa el resultado de la integral
 *
 *
 * @param  input  indica la entrada de la red neuronal
 *@param  weight  indica los pesos de la red neuronal
 * @return     El resultado de la funcion de activacion
 * @see         double
 */
   public static double sumProducto(double[] input,double[] weight) throws ExcepcionesRNA{
    double a=0.0;
    if(input.length!=weight.length)
    throw new ExcepcionesRNA("input size:"+input.length+" weight size:"+weight.length+" ");
    else{
        for(int x=0;x<input.length;x++)
            a+=(input[x]*weight[x]);
    }
    return a;
    }
 /**
 * Returns an double[] un vector escaldo
 * <p>
 * Este metodo escala un vector
 *
 *
 * @param  input  vector de entrada
 *@param  s  tamaño de la escala
 * @return     vector escalado
 * @see         double[]
 */
   public static double[] scala(double[] input,double s){
    double[] a=new double [input.length];
        for(int x=0;x<input.length;x++)
            a[x]=(input[x]*s);
    return a;
    }
  /**
 * Returns an double[] un vector sumado de a+b
 * <p>
 * Este metodo la suma de 2 vectores
 *
 *
 * @param  a  vector a
 *@param  b  vector b
 * @return     El resultado de la suma de los vectores
 * @see         double[]
 */
  public static double[] sum(double[] a,double[] b) throws ExcepcionesRNA{
    double[] r=new double [a.length];
    if(a.length!=b.length)
    throw new ExcepcionesRNA("a size:"+a.length+" b size:"+b.length+" ");
    else{
        for(int x=0;x<a.length;x++)
           r[x]=(a[x]+b[x]);
    }
    return r;
    }
   /**
 * Returns an double[] un vector adiciona elemento al vector
 * <p>
 * Este metodo la suma de 2 vectores
 *
 *
 * @param  a  vector a
 * @param  ele  elemento a adicionar
 * @return     El resultado de la suma de los vectores
 * @see         double[]
 */
  public static double[] add(double[]a,double ele){
    double[] r=new double [a.length+1];
    for(int x=0;x<a.length;x++)
        r[x]=a[x];
    r[a.length]=ele;
    return r;
    }
   /**
 * Returns an double[][] un vector producto de a*b
 * <p>
 * Este metodo la suma de 2 vectores
 *
 *
 * @param  a  vector a
 *@param  b  vector b
 * @return     El resultado es el producto vectores
 * @see         double[][]
 */
public static double[][] producto(double[] a,double[] b){
    double[][] r=new double [a.length][b.length];
    if(a.length!=b.length)
    try {
        throw new ExcepcionesRNA("a size:"+a.length+" b size:"+b.length+" ");
    } catch (ExcepcionesRNA ex) {
        Logger.getLogger(UtilRNA.class.getName()).log(Level.SEVERE, null, ex);
    }
    else{
       for(int x=0;x<a.length;x++){
           for(int y=0;y<b.length;y++){
           r[x][y]=0;
                r[x][y]+=a[x]*b[y];
           }
       }
    }
    return r;
    }
  /**
 * Returns an double[][] un vector sumado de a+b
 * <p>
 * Este metodo la suma de 2 vectores
 *
 *
 * @param  a  vector a
 *@param  b  vector b
 * @return     El resultado de la suma de los vectores
 * @see         double[][]
 */
public static double[][] sum(double[][] a,double[][] b){
    double[][] r=new double [a.length][b.length];
    if(a.length!=b.length||a[0].length!=b[0].length)
    try {
        throw new ExcepcionesRNA("a size:"+a.length+" b size:"+b.length+" ");
    } catch (ExcepcionesRNA ex) {
        Logger.getLogger(UtilRNA.class.getName()).log(Level.SEVERE, null, ex);
    }
    else{
       for(int x=0;x<a.length;x++){
           for(int y=0;y<a[0].length;y++){
           r[x][y]=a[x][y]+b[x][y];
           }
       }
    }
    return r;
    }
 /**
 * Returns an double[] un MATRIZ escaldo
 * <p>
 * Este metodo escala un vector
 *
 *
 * @param  a  vector de entrada
 *@param  b  tamaño de la escala
 * @return     Matriz escalada
 * @see         double[][]
 */
public static double[][] scala(double[][] a,double b){
    double[][] r=new double [a.length][a[0].length];
       for(int x=0;x<a.length;x++){
           for(int y=0;y<a[0].length;y++){
           r[x][y]=a[x][y]*b;
           }
       }
    return r;
}
  /**
 * Returns an double[][] un vector producto de a*b
 * <p>
 * Este metodo la suma de 2 vectores
 *
 *
 * @param  a  vector a
 *@param  b  vector b
 * @return     El resultado es el producto vectores
 * @see         double[][]
 */
public static double[] producto(double[][] a,double[] b){
    double[] r=new double[a.length];
    if(a[0].length!=b.length)
    try {
        throw new ExcepcionesRNA("a size:"+a.length+" b size:"+b.length+" ");
    } catch (ExcepcionesRNA ex) {
        Logger.getLogger(UtilRNA.class.getName()).log(Level.SEVERE, null, ex);
    }
    else{
       for(int x=0;x<a.length;x++){
           double ra=0;
           for(int y=0;y<a[0].length;y++){
               ra+=a[x][y]*b[y];
               
               }
           r[x]=ra;
       }
    }
    return r;
    }
//**** codigo externo
public  static double[][] matrizInversa(double[][] matriz) {
    double det=1/determinante(matriz);
    double[][] nmatriz=matrizAdjunta(matriz);
    multiplicarMatriz(det,nmatriz);
    return nmatriz;
}
 
public   static void multiplicarMatriz(double n, double[][] matriz) {
    for(int i=0;i<matriz.length;i++)
        for(int j=0;j<matriz.length;j++)
            matriz[i][j]*=n;
}
 
public static double[][] matrizAdjunta(double [][] matriz){
    return matrizTranspuesta(matrizCofactores(matriz));
}
 
public  static double[][] matrizCofactores(double[][] matriz){
    double[][] nm=new double[matriz.length][matriz.length];
    for(int i=0;i<matriz.length;i++) {
        for(int j=0;j<matriz.length;j++) {
            double[][] det=new double[matriz.length-1][matriz.length-1];
            double detValor;
            for(int k=0;k<matriz.length;k++) {
                if(k!=i) {
                    for(int l=0;l<matriz.length;l++) {
                        if(l!=j) {
                        int indice1=k<i ? k : k-1 ;
                        int indice2=l<j ? l : l-1 ;
                        det[indice1][indice2]=matriz[k][l];
                        }
                    }
                }
            }
            detValor=determinante(det);
            nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
        }
    }
    return nm;
}
 
public  static double[][] matrizTranspuesta(double [][] matriz){
    double[][]nuevam=new double[matriz[0].length][matriz.length];
    for(int i=0; i<matriz.length; i++)
    {
        for(int j=0; j<matriz.length; j++)
            nuevam[i][j]=matriz[j][i];
    }
    return nuevam;
}
 
public  static double determinante(double[][] matriz)
{
    double det;
    if(matriz.length==2)
    {
        det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
        return det;
    }
    double suma=0;
    for(int i=0; i<matriz.length; i++){
    double[][] nm=new double[matriz.length-1][matriz.length-1];
        for(int j=0; j<matriz.length; j++){
            if(j!=i){
                for(int k=1; k<matriz.length; k++){
                int indice=-1;
                if(j<i)
                indice=j;
                else if(j>i)
                indice=j-1;
                nm[indice][k-1]=matriz[j][k];
                }
            }
        }
        if(i%2==0)
        suma+=matriz[i][0] * determinante(nm);
        else
        suma-=matriz[i][0] * determinante(nm);
    }
    return suma;
}
}

