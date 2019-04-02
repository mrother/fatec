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
public class Circulo extends Ponto {
    
    private double raio;

    public Circulo() {
        super();
        this.raio = 1;
    }
    
    public Circulo(double x, double y, double raio) {
        super(x, y);
        this.raio = raio;
    }
    
    public Circulo(Circulo c) {
//        this(c.x, c.y, c.raio);
        super(c);
        this.raio = c.raio;        
    };
}