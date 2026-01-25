package warmUp;

import org.example.warmUp.WarmUpV1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarmUpV1Test {
    WarmUpV1 obj = new WarmUpV1();

    @BeforeAll
    static void beforAll(){
        System.out.println("Начало WarmUp 1");
    }

    @BeforeEach
    void beforEach(){
        System.out.println("First");
    }
    @Test
    void sleepInT() {
        Assertions.assertTrue(obj.sleepIn(false,false));
        Assertions.assertFalse(obj.sleepIn(true,false));
        Assertions.assertTrue(obj.sleepIn(false,true));
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Second");
    }

    @Test
    void monkeyTroubleT(){
        Assertions.assertTrue(obj.monkeyTrouble(true,true));
        Assertions.assertTrue(obj.monkeyTrouble(false,false));
        Assertions.assertFalse(obj.monkeyTrouble(false,true));
    }

    @BeforeEach
    void beforeEach1(){
        System.out.println("Third");
    }
    @Test
    void sumDouble(){
        Assertions.assertEquals(3,obj.sumDouble(1,2));
        Assertions.assertEquals(8,obj.sumDouble(2,2));
        Assertions.assertEquals(12,obj.sumDouble(3,3));
    }

}
