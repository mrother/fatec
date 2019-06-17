/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploexc;

/**
 *
 * @author 0040481721008
 */
public class ExemploExc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sm = 0, sb = 0, dv = 0, mt = 0;

        try {
            sm = Calc.sum(10, 30);
            sb = Calc.div(5, 3);
            dv = Calc.div(10, 0);
            mt = Calc.mult(5, 4);
        } catch (Exception e) {
            System.out.println(e);
            //System.out.println("Errou");
        }

        System.out.println(sm);
        System.out.println(sb);
        System.out.println(dv);
        System.out.println(mt);

    }

}
