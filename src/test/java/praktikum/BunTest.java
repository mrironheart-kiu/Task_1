package praktikum;

import org.junit.jupiter.api.*;
import praktikum.util.TestDataProvider;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(bunName, bun.getName());
    }

    @Test
    @DisplayName("Метод Bun.getPrice() возвращает стоимость булочки для бургера")
    void getPriceReturnsBunPriceTest() {
        assertEquals(bunPrice, bun.getPrice());
    }
}