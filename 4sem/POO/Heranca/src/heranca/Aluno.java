/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heranca;

/**
 *
 * @author 0040481721008
 */
public class Aluno extends Pessoa {

    private String ra;

    public Aluno(String nome, String rg, String ra) {
        super(nome, rg);
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void print() {
        System.out.println(this.getNome());
        System.out.println(this.getRg());
        System.out.println(this.ra);
    }
}
