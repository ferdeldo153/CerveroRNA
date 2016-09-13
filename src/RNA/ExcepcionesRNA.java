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
public class ExcepcionesRNA extends Exception  {
/**
 * Returns una excepcion en caso de que los parametros de algun argumento es invalido 
 * Se utiliza para indicar al programador si existe un parametro invalido
 * los argumentos son el texto de la exepcion
 *
 * @param  string  an absolute URL giving the base location of the image
 */
    public ExcepcionesRNA(String string) {
        super(string);
    }
    
}
