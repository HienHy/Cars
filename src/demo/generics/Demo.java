package demo.generics;

public class Demo <S>{
    /*
       S,E: Element reference
       N: Number
       T: Type
       K: key
       V: value
    */

    S element;

    public S getElement() {
        return element;
    }

    public void setElement(S element) {
        this.element = element;
    }

    public <E> void print(E msg){
        System.out.println(msg);
    }
}
