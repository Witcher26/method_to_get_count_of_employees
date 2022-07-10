package com.zvezdilin.MethodOfCountingEmployees;

import com.zvezdilin.MethodOfCountingEmployees.entites.State;
import com.zvezdilin.MethodOfCountingEmployees.entites.Task;

import java.util.*;

public class SomeClass {

    public static Optional<OptionalInt> getCountOfEmployees(HashMap<String, String> employeeTasks,
                                                        HashMap<String, String> taskStatuses) {
        List<Task> activeTasksList = new ArrayList<>();
        String message = "The field of statement to be added should not be null";

        for (Map.Entry<String, String> entry : taskStatuses.entrySet()) {
            String nonNullTask_id = Objects.requireNonNull(entry.getKey(), "task id: " + message);
            String nonNullTaskStatus = Objects.requireNonNull(entry.getValue(), "task status: " + message);

            if (nonNullTaskStatus.equalsIgnoreCase("active")) {
                activeTasksList.add(new Task(nonNullTask_id, employeeTasks.get(nonNullTask_id), State.ACTIVE)); // в целом, наличе State.ACTIVE опускает проверку на null этого поля
            }
        }

        Set<String> countOfEmployees = new HashSet<>();
        for (Task task : activeTasksList) {
            countOfEmployees.add(task.getAssignee_id());
        }
        return Optional.of(OptionalInt.of(countOfEmployees.size()));
    }
}



/*
  Написать метод, принимающий аргументом список, содержащий в себе структуры HashMap<String,String>, описывающие
  объекты типа "Задача проекта".
  Каждая HashMap<String,String> содержит в себе:
  - "task_id" - строка с идентификатором задач: уникальное значение, повторяющихся задач в списке нет. Не может быть пустой;
  - "assignee_id" - строка с идентификатором назначенного на задачу сотрудника: один сотрудник может быть назначен на несколько
  задач из списка. Может быть пустой строкой;
  - "task_state" - строка с названием статуса задачи: принимает одно из двух значений (active|disabled). Не может быть пустой;

  Метод должен вернуть целочисленное значение - количество уникальных сотрудников, назначенных на активные задачи из списка.

  Пример:
  Список, переданный как аргумент:
  [{task_id = 1, assignee_id = 001, task_state = active}, {task_id = 2, assignee_id = 002, task_state = active},
  {task_id = 3, assignee_id = 001, task_state = active}, {task_id = 4, assignee_id = 007, task_state = disabled}];

  Ожидаемое значение:
  2
 */

