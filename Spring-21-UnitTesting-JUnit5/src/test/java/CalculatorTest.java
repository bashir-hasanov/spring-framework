import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll() { // this needs to be static -> BeforeAll
        System.out.println("Before All is executed ... ");
    }

    @AfterAll
    static void tearDownAll() { // this needs to be static -> AfterAll
        System.out.println("After All is executed ... ");
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("Before Each is executed ... ");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("After Each is executed ... ");
    }

    @Test
    void testCase1() {
        System.out.println("Test Case 1");
        int actual = Calculator.add(3, 7);
        assertFalse(20 == actual, "Condition is true");
    }

    @Test
    void testCase2() {
        System.out.println("Test Case 2");
        assertTrue(Calculator.operator.equals("add"));
        //assertEquals("add", Calculator.operator);
    }

    @Test
    void testCase3() {
        System.out.println("Test Case 3");
        assertArrayEquals(new int []{1, 2, 3}, new int [] {1, 2, 3});
    }

    @Test
    void testCase4() {
        System.out.println("Test Case 4");
        String nullStr = null;
        assertNotNull(Calculator.operator);
        //assertNull(nullStr);
        //assertNull(Calculator.operator);
        //assertNotNull(nullStr);
    }

    @Test
    void testCase5() {
        System.out.println("Test Case 5");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();
        //assertSame(c1, c2, "Objects' reference is not same");
        assertNotSame(c1, c3);
    }


    @Test
    void add() {
        System.out.println("add");
        int actual = Calculator.add(12, 13);
        assertEquals(25, actual, "ACTUAL value does not match with EXPECTED value");
        //assertTrue(25 == actual, "Conditions is NOT met");
    }

    @Test
    void add2() {
        System.out.println("add 2");
       assertThrows(IllegalArgumentException.class, () -> Calculator.add2(7, 2));
       //assertThrows(AccessDeniedException.class, () -> Calculator.add2(7, 2)); --> FAIL, wrong exception type
        //assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2, 7)); --> FAIL, num1 < num2
    }
}