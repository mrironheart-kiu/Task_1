package praktikum;

import org.junit.jupiter.api.*;
import praktikum.testdata.TestDataProvider;

import static org.junit.jupiter.api.Assertions.*;
import static praktikum.constant.ErrorConstant.DEFAULT_ERROR_MESSAGE;

class BunTest {
    private TestDataProvider testData;
    private String bunName;
    private float bunPrice;
    private Bun bun;

    @BeforeEach
    void setUp() {
        testData = new TestDataProvider();
        bunName = testData.getRandomName();
        bunPrice = testData.getRandomFloatPrice();
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    @DisplayName("Метод Bun.getName() возвращает наименование булочки для бургера")
    void getNameReturnsBunNameTest() {
        assertEquals(bunName, bun.getName(), DEFAULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Метод Bun.getPrice() возвращает стоимость булочки для бургера")
    void getPriceReturnsBunPriceTest() {
        assertEquals(bunPrice, bun.getPrice(), DEFAULT_ERROR_MESSAGE);
    }
}