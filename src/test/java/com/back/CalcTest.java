package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// build.gradle.kts 의 dependencies 블록에 `testImplementation("org.assertj:assertj-core:3.27.3")` 추가 후 그래들 리프레시 해야 아래 라이브러리 사용 가능
import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(Calc.
                run("1 + 1"))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2() {
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 + 2 == 4")
    void t3() {
        assertThat(Calc.run("2 + 2")).isEqualTo(4);
    }

    @Test
    @DisplayName("1000 + 280 == 1280")
    void t4() {
        assertThat(Calc.
                run("1000 + 280")).
                isEqualTo(1280);
    }

    @Test
    @DisplayName("2 - 1 == 1")
    void t5() {
        assertThat(Calc.
                run("2 - 1")).isEqualTo(1);
    }

    @Test
    @DisplayName("3 - 1 == 2")
    void t6() {
        assertThat(Calc.run("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("100 - 20 == 80")
    void t7() {
        assertThat(Calc.run("100 - 20")).isEqualTo(80);
    }

    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t8() {
        assertThat(Calc.
                run("10 + 20 + 30")).
                isEqualTo(60);
    }

    @Test
    @DisplayName("10 - 20 + 30 == 20")
    void t9() {
        assertThat(Calc.
                run("10 - 20 + 30")).
                isEqualTo(20);
    }

    @Test
    @DisplayName("10 - 10 - 10 - 10 == -20")
    void t10() {
        assertThat(Calc.run("10 - 10 - 10 - 10")).isEqualTo(-20);
    }

    @Test
    @DisplayName("10 - 10 - 10 - 10 + 10 + 10 - 10 == -10")
    void t11() {
        assertThat(Calc.run("10 - 10 - 10 - 10 + 10 + 10 - 10")).isEqualTo(-10);
    }

    @Test
    @DisplayName("10 * 10 == 100")
    void t12() {
        assertThat(Calc.
                run("10 * 10"))
                .isEqualTo(100);
    }

    @Test
    @DisplayName("10 * -10 == -100")
    void t13() {
        assertThat(Calc.
                run("10 * -10")).isEqualTo(-100);
    }

    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t14() {
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }




}
