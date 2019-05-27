/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploint.sorter;

/**
 *
 * @author 0040481721008
 */
public class SortedList {

    private SorteableItem List[];
    private int count;

    public SortedList(int qtdd) {
        List = new SorteableItem[qtdd];
        count = 0;
    }

    public boolean Add(SorteableItem item) {
        if (count >= List.length) {
            return false;
        }
        List[count] = item;
        count++;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            List[i].printItem();
        }
    }

    public void sort() {
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (List[j].valueToSort() < List[i].valueToSort()) {
                    SorteableItem tmp = List[i];
                    List[i] = List[j];
                    List[j] = tmp;
                }
            }
        }
    }

}
