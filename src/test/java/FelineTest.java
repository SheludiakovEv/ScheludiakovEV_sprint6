import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatCallMethodReturnList() throws Exception {
        Feline felineSpy = Mockito.spy(feline);
        List<String> expRes = List.of("testData1", "testData2");
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(expRes);
        assertEquals("метод должен возвращать список: ", expRes, felineSpy.eatMeat());
    }

    @Test
    public void getFamilyCallMethodReturnKoshachi() {
        String expRes = "Кошачьи";
        assertEquals("метод должен возвращать стрингу: ", expRes, feline.getFamily());
    }

    @Test
    public void getKittensCallMethodWithoutArgumentReturnIntOne() {
        int expRes = 1;
        assertEquals("без аргументов метод getKittens() должен возвращать int: ",
                expRes, feline.getKittens());
    }

    @Test
    public void getKittensCallMethodWithArgumentReturnThisArgument() {
        int expRes = 9;
        assertEquals("с интовым аргументом метод getKittens() должен возвращать этот самый аргумент",
                expRes, feline.getKittens(expRes));
    }
}
