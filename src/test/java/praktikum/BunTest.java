package praktikum;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BunTest {
    private String bunName;
    private float bunPrice;
    private Bun bun;

    @BeforeEach
    void setUp() {
        Faker faker = new Faker();
        Random random = new Random();

        bunName = faker.name().name();
        bunPrice = Float.MIN_VALUE + random.nextFloat() * (Float.MAX_VALUE - Float.MIN_VALUE);
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