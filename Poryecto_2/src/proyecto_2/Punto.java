
package proyecto_2;

public class Punto {
    private int x;
    private int y;
    
    /**
     * Generar un punto en las coordenadas 0,0
     */
    public Punto(){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Generar un punto con las coordenadas (x,y)
     * @param x coordenada x en el punto
     * @param y coordenada y en el punto
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Asignar valor de la coordenada 
     * @param x coordenada en x
     */
    
    public void setX(int x){
        this.x = x;
    }

    /**
     * Obtener el valor en la coordenada en x
     * @return Coordenada en x del punto
     */
    
    public int getX() {
        return this.x;
    }
    
    /**
     * Asignar valor de la coordenada 
     * @param y coordenada en y
     */
    
    public void setY(int y){
        this.y = y;
    }

    /**
     * Obtener el valor en la coordenada en y
     * @return Coordenada en y del punto
     */
    
    public int getY() {
        return this.y;
    }
    
}
