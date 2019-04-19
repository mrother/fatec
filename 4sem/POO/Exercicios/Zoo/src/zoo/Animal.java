/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

/**
 *
 * @author 0040481721008
 */
public abstract class Animal {

    public abstract void fazerSom();

    public void fome() {
        fazerSom();
        fazerSom();
        fazerSom();
    }
}
