package praktikum;

import org.junit.jupiter.api.*;
import praktikum.util.TestDataProvider;

import static org.junit.jupiter.api.Assertions.*;
import static praktikum.IngredientType.SAUCE;
import static praktikum.util.ErrorConstant.DEFAULT_ERROR_MESSAGE;

class IngredientTest {
    private TestDataProvider testData;
    private Ingredient ingredient;
    private String ingredientName;
    private float ingredientPrice;

    @BeforeEach
    void setUp() {
        testData = new TestDataProvider();
        ingredientName = testData.getRandomName();
        ingredientPrice = testData.getRandomFloatPrice();
        ingredient = new Ingredient(SAUCE, ingredientName, ingredientPrice);
    }

    @Test
    @DisplayName("Метод Ingredient.getPrice() возвращает стоимость ингридиента для бургера")
    void getPriceReturnsIngredientPriceTest() {
        assertEquals(ingredientPrice, ingredient.getPrice(), DEFAULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Метод Ingredient.getName() возвращает наименование ингридиента для бургера")
    void getNameReturnsIngredientNameTest() {
        assertEquals(ingredientName, ingredient.getName(), DEFAULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Метод Ingredient.getType() возвращает тип ингридиента для бургера")
    void getTypeReturnsIngredientTypeNameTest() {
        assertEquals(SAUCE, ingredient.getType(), DEFAULT_ERROR_MESSAGE);
    }
}