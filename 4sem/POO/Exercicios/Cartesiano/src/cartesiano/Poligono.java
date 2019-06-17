/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartesiano;

/**
 *
 * @author 0040481721008
 *
 * Para o projeto Cartesiano, acrescente a classe Poligono. Esta classe mantém
 * uma lista de pontos (da classe Ponto) que representam os vértices do
 * polígono. Para este projeto, um polígono pode ter no máximo 50 vértices. O
 * polígono é criado sem vértices e depois eles são adicionados usando o método
 * apropriado.
 */
public class Poligono {

    private Ponto vert[];
    private int count;

    public Poligono() {
        this.count = 0;
        vert = new Ponto[50];
    }

    /**
     * retorna true se o ponto já existe na lista de vértices ou false se não
     * existe.
     *
     * @param pt
     * @return
     */
    public boolean ptExist(Ponto pt) {
        double x = pt.getX();
        double y = pt.getY();

        for (int i = 0; i < count; i++) {
            if (x == vert[i].getX() && y == vert[i].getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um novo vértice no final da lista. Retorna true se o vértice foi
     * adicionado com sucesso ou false se houve algum erro. São condições de
     * erro: - O ponto já existe na lista. - O polígono já tem 50 vértices.
     *
     * @param pt
     * @return
     */
    public boolean addVertex(Ponto pt) {
        if (this.count >= 50 || ptExist(pt)) {
            return false;
        }
        vert[this.count] = pt;
        this.count++;
        return true;
    }

    /**
     * Informa se é um polígono válido ou não. Para este método, um polígono é
     * válido se tiver pelo menos 3 vértices.
     *
     * @return
     */
    public boolean isValid() {
        return this.count >= 3;
    }

    /**
     * retorna o perímetro do polígono. Se não é um polígono válido, deve
     * retornar -1.
     *
     * @return
     */
    public double perimeter() {
        if (!isValid()) {
            return -1;
        }
        double per = vert[0].distance(vert[count - 1]);
        for (int i = 0; i < count - 1; i++) {
            per += vert[i].distance(vert[i + 1]);
        }
        return per;
    }

    /**
     * retorna o ponto que é o centro geométrico do polígono. O centro
     * geométrico pode ser calculado fazendo a média de todos os vértices.
     *
     * @return
     */
    public Ponto geoCenter() {
        if (!isValid()) {
            return null;
        }

        double x = 0, y = 0;

        for (int i = 0; i < count; i++) {
            x += vert[i].getX();
            y += vert[i].getY();
        }

        return new Ponto(x / count, y / count);
    }

    /**
     * retorna a distância entre o centro geométrico do polígono no objeto e o
     * centro geométrico do polígono informado no parâmetro.
     *
     * @param plg
     * @return
     */
    public double distance(Poligono plg) {
        Ponto gc = geoCenter();
        Ponto pgc = plg.geoCenter();

        return gc.distance(pgc);
    }

    /**
     * desloca o polígono com os valores informados.
     *
     * @param dx
     * @param dy
     */
    public void desloc(double dx, double dy) {
        for (int i = 0; i < count; i++) {
            vert[i].desloc(dx, dy);
        }
    }

    /**
     * faz o escalonamento do polígono usando o fator informado.
     *
     * @param factor
     */
    public void escale(double factor) {
        for (int i = 0; i < count; i++) {
            vert[i].scale(factor);
        }
    }
}
