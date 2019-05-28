package exercise.date_0507;

import org.junit.jupiter.api.Test;

public class Num_swop {



    @Test
    public void test(){
        System.out.println();
        int a = 1;
        int b = 20;
        int c = 300;

        a = a+b+c; //321
        b = a-b-c; // 1
        c = a-b-c; //20
        a = a-b-c;

        //System.out.println("a:"+a+" b:"+b+" c:"+c);



    }
}
