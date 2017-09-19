import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*файл с тестами*/
public class AutomatTest {
    @Test
    public  void test(){
        Automat automat = new Automat();
        init(automat);
        assertEquals(true,automat.isStringNumber("12312312412"));
        assertEquals(true,automat.isStringNumber("-123123"));
        assertEquals(true,automat.isStringNumber("19187983988229638601"));
        assertEquals(true,automat.isStringNumber("94464056955628702760"));
        assertEquals(true,automat.isStringNumber("72182769153987999191"));
        assertEquals(true,automat.isStringNumber("56838770810752526248"));
        assertEquals(true,automat.isStringNumber("74694058454950708705"));
        assertEquals(false,automat.isStringNumber("12a"));
        assertEquals(false,automat.isStringNumber("1a12"));
        assertEquals(false,automat.isStringNumber("lDSoOQfGj6BXHdzI1atl"));
        assertEquals(false,automat.isStringNumber("lb7hzrTpIbhgCmy9EnxK"));
        assertEquals(false,automat.isStringNumber("112393lb7hzrTpIbhgCmy9EnxK"));
        assertEquals(false,automat.isStringNumber("1a12"));
        assertEquals(false, automat.isStringNumber("00000000000000000000000000a"));
        assertEquals(true,automat.isStringNumber("-009"));
        assertEquals(false,automat.isStringNumber("009"));

    }

    private static void init(Automat automat) {
        //записываем от точки к точке по-порядку
        automat.addStep(0,1,"-",true,false);
        automat.addStep(0,2,"123456789",true,false);
        automat.addStep(1,2,"0123456789",false,false);
        automat.addStep(2,2,"0123456789",false,true);
    }
}
