package task.manager;

import java.util.Arrays;

public class ArrayTaskList {
    private Task[] arreyTasks = new Task[10];
    private int size = 0;

    public void add(Task task) throws NullPointerException {
        if (task != null) {
            if (size == arreyTasks.length) {
                arreyTasks = Arrays.copyOf(arreyTasks,arreyTasks.length * 2);
            }
            arreyTasks[size] = task;
            size++;
        } else {
            throw new NullPointerException("The task cannot be null");
        }
    }
    public boolean remove(Task task) {
        if (task != null) {
            if (arreyTasks.length == 0) {
                return false;
            }
            for (int i = 0; i < arreyTasks.length; i++) {
                if (arreyTasks[i].equals(task)) {
                    arreyTasks[i] = null;
                    System.arraycopy(arreyTasks, i + 1, arreyTasks, i, (arreyTasks.length - 1) - i);
                    size--;
                    return true;
                }
            }
        } else {
            throw new NullPointerException("The task cannot be null");
        }
        return false;
    }

    public int size() {
        int size = 0;
        for (Task task : arreyTasks) {
            if (task != null) {
                size = size + 1;
            }
        }
        return size;
    }
    public Task getTask(int index) {
        if(index < 0 || index > arreyTasks.length) {
            throw new IndexOutOfBoundsException("index is out if bounds");
        }
        return arreyTasks[index];
    }

    public ArrayTaskList incoming(int from, int to) {
       ArrayTaskList arrayTaskList = new ArrayTaskList();
        for (Task arreyTask : arreyTasks) {
            if (arreyTask.nextTimeAfter(from) != -1 && arreyTask.getEndTime() <= to) {
                if (arreyTask.isActive()) {
                    arrayTaskList.add(arreyTask);
                }
            }
        }
        return arrayTaskList;
    }
}
