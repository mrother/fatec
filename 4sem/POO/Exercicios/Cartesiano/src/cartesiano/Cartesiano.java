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
public class Cartesiano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ponto p1 = new Ponto();
        Ponto p2 = new Ponto(30, 40);
        
        p1.setX(10);
        p1.setY(20);
        
        p1.print("alfa");
        p2.print("beta");
        
        Ponto p3 = new Ponto(p2);
        
        p3.print("novo");
        
        p1.scale(2);
        p1.print("scale");
        
        p1.desloc(5, 10);
        p1.print("desloc");
        
        double dst = p1.distance(50, 50);
        System.out.println(dst);
        
        Segmento s = new Segmento(p1, p2);
        
        s.print();
    }
    
}
