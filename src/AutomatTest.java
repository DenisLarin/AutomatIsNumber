import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AutomatTest {
    @Test
    public  void test(){
        Automat automat = new Automat();
        init(automat);
        assertEquals(true,automat.isStringNumber("12312312412"));
        assertEquals(true,automat.isStringNumber("-123123"));
        assertEquals(false,automat.isStringNumber("12a"));
        assertEquals(false,automat.isStringNumber("1a12"));
        assertEquals(false, automat.isStringNumber("00000000000000000000000000a"));

    }

    private static void init(Automat automat) {
        //записываем от точки к точке по-порядку
        automat.addStep(0,1,"-",true,false);
        automat.addStep(0,2,"123456789",true,false);
        automat.addStep(1,2,"0123456789",false,false);
        automat.addStep(2,2,"0123456789",false,true);
    }
}
