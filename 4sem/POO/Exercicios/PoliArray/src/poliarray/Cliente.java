/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliarray;

/**
 *
 * @author 0040481721008
 */
public class Cliente extends Contato {

    String empresa;

    public Cliente(String nome, String fone, String empresa) {
        super(nome, fone);
        this.empresa = empresa;
    }
   
    public void print() {
        System.out.println(
                "Nome: " + nome + "\n"
                + "Fone: " + fone + "\n"
                + "Empresa: " + empresa + "\n"
        );
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
