package praktikum.testdata;

import org.junit.jupiter.params.provider.Arguments;
import praktikum.Ingredient;

import java.util.stream.Stream;

import static praktikum.IngredientType.*;

public class ParameterizedTestData {
    private static TestDataProvider testData;

    private static Stream<Arguments> ingredientTestData() {
        testData = new TestDataProvider();
        return Stream.of(
                Arguments.of(SAUCE, new Ingredient(SAUCE, testData.getRandomName(), testData.getRandomFloatPrice())),
                Arguments.of(FILLING, new Ingredient(FILLING, testData.getRandomName(), testData.getRandomFloatPrice()))
        );
    }
}
