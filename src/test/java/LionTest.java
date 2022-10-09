import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void LionCallConstructionInvalidSexGetException() throws Exception {
        Exception e = assertThrows(Exception.class, () ->
                lion = new Lion("invalidData", feline));
        String expRes = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals("должно вернуться исключение с сообщением: ", expRes, e.getMessage());

    }

    @Test
    public void getKittensCallMethodReturnOne() {
        //MockitoAnnotations.initMocks(this);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expRes = 1;
        assertEquals("метод должен вернуть int == ", expRes, lion.getKittens());
    }

    @Test
    public void getFoodCallMethodReturnList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("testData1", "testData2"));
        List<String> expRes = List.of("testData1", "testData2");
        assertEquals("метод должен возвращать список: ", expRes, lion.getFood());
    }

}
