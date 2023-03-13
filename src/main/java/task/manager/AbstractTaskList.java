package task.manager;

import java.io.Serializable;

public abstract class AbstractTaskList implements Iterable<Task>, Serializable {

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index);

}
