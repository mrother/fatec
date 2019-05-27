package poliarray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 0040481721008
 */
public class Amigo extends Contato {
    String aniversario;

    public Amigo(String nome, String fone, String aniversario) {
        super(nome, fone);
        this.aniversario = aniversario;
    }
    
    public void print() {
        System.out.println(
                "Nome: " + nome + "\n" +
                "Fone: " + fone + "\n" +
                "Aniversário: " + aniversario + "\n"
        );
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    
}
