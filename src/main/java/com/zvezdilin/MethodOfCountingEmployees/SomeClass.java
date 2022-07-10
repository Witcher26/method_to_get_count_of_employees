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
                activeTasksList.add(new Task(nonNullTask_id, employeeTasks.get(nonNullTask_id), State.ACTIVE)); // � �����, ������ State.ACTIVE �������� �������� �� null ����� ����
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
  �������� �����, ����������� ���������� ������, ���������� � ���� ��������� HashMap<String,String>, �����������
  ������� ���� "������ �������".
  ������ HashMap<String,String> �������� � ����:
  - "task_id" - ������ � ��������������� �����: ���������� ��������, ������������� ����� � ������ ���. �� ����� ���� ������;
  - "assignee_id" - ������ � ��������������� ������������ �� ������ ����������: ���� ��������� ����� ���� �������� �� ���������
  ����� �� ������. ����� ���� ������ �������;
  - "task_state" - ������ � ��������� ������� ������: ��������� ���� �� ���� �������� (active|disabled). �� ����� ���� ������;

  ����� ������ ������� ������������� �������� - ���������� ���������� �����������, ����������� �� �������� ������ �� ������.

  ������:
  ������, ���������� ��� ��������:
  [{task_id = 1, assignee_id = 001, task_state = active}, {task_id = 2, assignee_id = 002, task_state = active},
  {task_id = 3, assignee_id = 001, task_state = active}, {task_id = 4, assignee_id = 007, task_state = disabled}];

  ��������� ��������:
  2
 */

