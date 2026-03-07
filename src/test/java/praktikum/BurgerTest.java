package praktikum;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.util.TestDataProvider;

import static org.junit.jupiter.api.Assertions.*;
import static praktikum.IngredientType.SAUCE;
import static praktikum.util.ErrorConstant.DEFAULT_ERROR_MESSAGE;

@ExtendWith(MockitoExtension.class)
class BurgerTest {
    private TestDataProvider testData;
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        testData = new TestDataProvider();
        burger = new Burger();
    }

    @Test
    @DisplayName("Метод Burger.setBuns() устанавливает булочку для бургера")
    void setBunsSetsBunForBurgerTest() {
        burger.setBuns(bun);

        assertEquals(burger.bun, bun);
    }

    @Test
    @DisplayName("Метод Burger.addIngredient() добавляет элемент в массив ингридиентов")
    void addIngredientAddsIngredientIntoIngredientArrayTest() {
        burger.addIngredient(ingredient);

        assertTrue(burger.ingredients.contains(ingredient), DEFAULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Метод Burger.removeIngredient() удаляет элемент из массива ингридиентов")
    void removeIngredientRemovesIngredientIntoIngredientArrayTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty(), DEFAULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Метод Burger.getPrice() возвращает сумму двух булочек и сумму всех ингридиентов")
    void getPriceReturnsSumOfTwoBunsAndAllIngredientsTest() {
        float bunPrice = testData.getRandomFloatPrice();
        float ingredientPrice = testData.getRandomFloatPrice();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        assertEquals(bunPrice * 2 + ingredientPrice, burger.getPrice(), DEFAULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Метод Burger.getPrice() вызывает метод Bun.getPrice() один раз")
    void getPriceCallsBunGetPriceOnceTest() {
        float bunPrice = testData.getRandomFloatPrice();

        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.getPrice();

        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    @DisplayName("Метод Burger.getPrice() вызывает метод Ingredient.getPrice() для всех елементов массива ингридиентов")
    void getPriceCallsIngredientGetPriceForEachIngredientTest() {
        float bunPrice = testData.getRandomFloatPrice();
        float ingredientPrice = testData.getRandomFloatPrice();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.getPrice();

        Mockito.verify(ingredient, Mockito.times(burger.ingredients.size())).getPrice();
    }

    @Test
    @DisplayName("Метод Burger.getReceipt() вызывает метод Bun.getName() два раза")
    void getReceiptCallsBunGetNameTwiceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(testData.getRandomName());
        burger.getReceipt();

        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    @Test
    @DisplayName("Метод Burger.getReceipt() вызывает метод Ingredient.getName() для всех елементов массива ингридиентов")
    void getReceiptCallsIngredientGetNameForEachIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(testData.getRandomName());
        burger.getReceipt();

        Mockito.verify(ingredient, Mockito.times(burger.ingredients.size())).getName();
    }
}