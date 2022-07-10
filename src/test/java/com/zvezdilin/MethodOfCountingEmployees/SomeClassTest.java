package com.zvezdilin.MethodOfCountingEmployees;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SomeClassTest {
    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }


    @Test
    public void testMethodOfCountingEmployees() {
        //arrange
        HashMap<String, String> employeeTasks = new HashMap<>();
        HashMap<String, String> taskStatuses = new HashMap<>();

        employeeTasks.put("1", "001");
        employeeTasks.put("2", "002");
        employeeTasks.put("3", "001");
        employeeTasks.put("4", "007");

        taskStatuses.put("1", "active");
        taskStatuses.put("2", "active");
        taskStatuses.put("3", "active");
        taskStatuses.put("4", "disabled");

        //act
        Optional<OptionalInt> expected = Optional.of(OptionalInt.of(2));
        Optional<OptionalInt> resultCount = SomeClass.getCountOfEmployees(employeeTasks, taskStatuses);

        //assert
        Assertions.assertEquals(expected, resultCount);
    }

    @Test
    public void testMethodOfCountingEmployeesWithNullField() {
        //arrange
        HashMap<String, String> employeeTasks = new HashMap<>();
        HashMap<String, String> taskStatuses = new HashMap<>();

        employeeTasks.put("1", "001");
        employeeTasks.put("2", "002");
        employeeTasks.put("3", "001");
        employeeTasks.put("4", "007");

        taskStatuses.put("1", "active");
        taskStatuses.put("2", "active");
        taskStatuses.put("3", null);
        taskStatuses.put("4", "disabled");

        //act
        String expected = "task status: The field of statement to be added should not be null";
        Throwable thrown = catchThrowable(() -> {
            SomeClass.getCountOfEmployees(employeeTasks, taskStatuses);
        });

        //assert
        assertThat(thrown).isInstanceOf(NullPointerException.class);
        Assertions.assertEquals(expected, thrown.getMessage());
    }
}
