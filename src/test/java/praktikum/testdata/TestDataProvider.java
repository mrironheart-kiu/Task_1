package praktikum.testdata;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Класс для формирования тестовых данных в тестах
 */
public class TestDataProvider {
    private final Random RANDOM = new Random();
    private final Faker FAKER = new Faker();

    public float getRandomFloatPrice(){
        return 0.01f + RANDOM.nextFloat() * (100.00f - 0.01f);
    }

    public String getRandomName(){
        return FAKER.name().name();
    }
}
