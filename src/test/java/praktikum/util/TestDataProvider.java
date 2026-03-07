package praktikum.util;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestDataProvider {
    private final Random RANDOM = new Random();
    private final Faker FAKER = new Faker();

    public float getRandomFloatPrice(){
        return Float.MIN_VALUE + RANDOM.nextFloat() * (Float.MAX_VALUE - Float.MIN_VALUE);
    }

    public String getRandomName(){
        return FAKER.name().name();
    }
}
