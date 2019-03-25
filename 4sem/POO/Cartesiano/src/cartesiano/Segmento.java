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
public class Segmento {

    private Ponto p1, p2;

    public Segmento() {
        p1 = new Ponto(); // padrão é (0, 0)
        p2 = new Ponto(1, 0);
    }

    public Segmento(double x1, double x2, double y1, double y2) {
        this.p1 = new Ponto(x1, x2);
        this.p2 = new Ponto(y1, y2);
    }

    public Segmento(Ponto p1, Ponto p2) {
        this.p1 = new Ponto(p1);
        this.p2 = new Ponto(p2);
    }

    public Segmento(Segmento seg) {
        this(seg.p1, seg.p2);
    }

    public void scale(double factor) {
        this.p1.scale(factor);
        this.p2.scale(factor);
    }

    public void desloc(double dx, double dy) {
        this.p1.desloc(dx, dy);
        this.p2.desloc(dx, dy);
    }

    /**
     * Calcula a distancia entre os dois pontos na reta.
     *
     * @return
     */
    public double length() {
        return p1.distance(p2);
    }

    /**
     * Média das coordenadas
     *
     * @return
     */
    public Ponto midPoint() {
        double mx = (p1.getX() + p2.getX()) / 2;
        double my = (p1.getY() + p2.getY()) / 2;

        return new Ponto(mx, my);
    }

    /**
     * Retorna a distância do ponto médio do segmento até a origem,
     *
     * @return
     */
    public double distance() {
        Ponto pm = midPoint();
        return pm.distance();
    }

    /**
     * Retorna a distância do ponto médio até o ponto médio de s
     *
     * @return
     */
    public double distance(Segmento s) {
        Ponto pm = midPoint();
        Ponto pms = s.midPoint();
        return pm.distance(pms);
    }

    public String toString() {
        return "[" + p1 + "," + p2 + "]";
    }

    public void print() {
        System.out.println(this);
    }
}
