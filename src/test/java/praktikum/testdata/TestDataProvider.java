package praktikum.testdata;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Класс для формирования тестовых данных в тестах
 */
public class TestDataProvider {
    private final Random RANDOM = new Random();
    private final Faker FAKER = new Faker();

    /**
     * Метод возвращает случайное значение типа float
     *
     * @return float
     */
    public float getRandomFloatPrice() {
        return 0.01f + RANDOM.nextFloat() * (100.00f - 0.01f);
    }

    /**
     * Метод возвращает случайное имя из генератора JavaFaker
     *
     * @return String
     */
    public String getRandomName() {
        return FAKER.name().name();
    }
}
