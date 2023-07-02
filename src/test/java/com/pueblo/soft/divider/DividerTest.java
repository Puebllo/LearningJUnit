package com.pueblo.soft.divider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DividerTest {

    private Divider divider = null;

    @BeforeEach
    void initEach(){
        divider = new Divider();
    }

    @Test
    void testCustomConstructor(){
        divider = new Divider(21.0,37.0);
        assertThat(divider.getNumerator()).isEqualTo(21.0);
        assertThat(divider.getDenominator()).isEqualTo(37.0);
    }

    @Test
    void checkIfInstantiatesCorrectlyWithoutParams(){
        assertThat(divider.getNumerator()).isEqualTo(0.0);
        assertThat(divider.getDenominator()).isEqualTo(0.0);
    }

    @Test
    void checkIfInstantiatesCorrectlyWithParams(){
        divider.setNumerator(5.0);
        divider.setDenominator(2.0);

        assertThat(divider.getNumerator()).isEqualTo(5.0);
        assertThat(divider.getDenominator()).isEqualTo(2.0);
    }

    @Test
    void doDivideNumeratorDenominatorAreTheSameNotZero(){
        divider.setNumerator(10.0);
        divider.setDenominator(10.0);

        assertThat(divider.divide()).isEqualTo(1.0);
    }

    @Test
    void doDivideNumeratorWithNumberAndDenominatorWithZero(){
        divider.setNumerator(10.0);
        divider.setDenominator(0.0);

        assertThatThrownBy(() -> divider.divide())
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void doDivideNumeratorAndDenominatorWithZero(){
        divider.setNumerator(0.0);
        divider.setDenominator(0.0);

        assertThatThrownBy(() -> divider.divide())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void doDivideNumeratorWithZeroAndDenominatorWithNumber(){
        divider.setNumerator(0.0);
        divider.setDenominator(10.0);

        assertThat(divider.divide()).isEqualTo(0.0);

    }

    @Test
    void doDivideNumeratorGreaterAndDenominatorLesser(){
        divider.setNumerator(15.0);
        divider.setDenominator(5.0);

        assertThat(divider.divide()).isEqualTo(3.0);

    }

    @Test
    void doDivideNumeratorLesserAndDenominatorGreater(){
        divider.setNumerator(50.0);
        divider.setDenominator(100.0);

        assertThat(divider.divide()).isEqualTo(0.5);

    }

}