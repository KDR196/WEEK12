package com.prominotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.prominotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	    assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
	    assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	    assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
	    assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
	    assertThat(testDemo.addPositive(15, 25)).isEqualTo(40);
	}


	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
			arguments(2, 4, 6, false),
			arguments(0, 4, 0, true),  // Example of zero, expecting an exception
			arguments(-1, 4, 0, true), // Example of negative, expecting an exception
			arguments(3, 7, 10, false),
			arguments(5, 5, 10, false),
			arguments(-3, -7, 0, true) // Example of negative, expecting an exception
		);
	}
	
	@ParameterizedTest
    @MethodSource("com.prominotech.TestDemoJUnitTest#argumentsForDividePositive")
    void assertThatTwoPositiveNumbersAreDividedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.dividePositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.dividePositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForDividePositive() {
        return Stream.of(
            arguments(10, 2, 5, false),
            arguments(20, 5, 4, false),
            arguments(0, 4, 0, true),   // Example of zero, expecting an exception
            arguments(-10, 2, 0, true), // Example of negative, expecting an exception
            arguments(10, -2, 0, true), // Example of negative, expecting an exception
            arguments(9, 3, 3, false)
        );
    }
    @Test
    void assertThatNumberSquaredIsCorrect() {
    	// Create a copy of TestDemo that we can control
        TestDemo mockDemo = Mockito.spy(new TestDemo());
     // Make it always give us 5 when we ask for a random number
        Mockito.doReturn(5).when(mockDemo).getRandomInt();
     // Calculate what happens when we square the number 5
        int fiveSquared = mockDemo.randomNumberSquared();
        // Check that the result is exactly 25, because 5 squared is 25
        assertThat(fiveSquared).isEqualTo(25);
    }
}
