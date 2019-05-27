/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartesiano;

/**
 *
 * @author 0040481721008
 */
public class Ponto {
    protected double x, y;

    // construtor pradrão

    /**
     *
     */
    public Ponto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     *
     * @param x
     * @param y
     */
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    

    /**
     * Copy constructor
     * @param pt
     */
    public Ponto(Ponto pt)
    {
       this(pt.x, pt.y);
    }

    /**
     * Escala o ponto multiplicando suas coordenadas
     * pelo fator de deslocamento indicado
     * 
     * @param factor 
     */
    public void scale(double factor)
    {
        this.setX(this.getX() * factor);
        this.setY(this.getY() * factor);
    }
    
    /**
     * Desloca o ponto somando os deslocamentos dx e dy
     * em x e y respectivamente
     * 
     * @param dx
     * @param dy 
     */
    public void desloc(double dx, double dy)
    {
        this.setX(this.x + dx);
        this.setY(this.y + dy);
    }
    
    /**
     * Retorna a distância do ponto até a posição indicada
     * Delta(x) = x2 - x1
     * Delta(y) = y2 - y1
     * distancia = Raiz quadrada de Delt(x)^2 + Delta(y)^2
     * Usar a classe Math.sqrt()
     * 
     * @param dx
     * @param dy
     * @return 
     */
    public double distance(double dx, double dy)
    {
        double deltaX = dx - this.getX();
        double deltaY = dy - this.getY();
        
        double dist = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return dist;
    }
    
    /**
     * Retorna a distância do ponto até a origem (0,0)
     * 
     * @param pt
     * @return 
     */
    public double distance()
    {
        return distance(0, 0);
    }
    
    /**
     * Retorna a distância até o ponto informado no parâmetro
     * @param pt
     * @return 
     */
    public double distance(Ponto pt)
    {
        return distance(pt.x, pt.y);
    }
    
    /**
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     *
     * @param caption
     */
    public void print(String caption)
    {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y +")";
    }
    
}
