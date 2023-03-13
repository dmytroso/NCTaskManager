package task.manager;

import java.util.Iterator;
import java.util.LinkedList;


public class LinkedTaskList extends AbstractTaskList implements Cloneable  {
    private Node headNode;
    private Node tailNode;
    int countOfElements = 0;
    LinkedList
    @Override
    public LinkedTaskList clone() {
        try {
            LinkedTaskList clone = (LinkedTaskList) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private static class Node {
    }
    @Override
    public void add(Task task) {

    }

    @Override
    public boolean remove(Task task) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Task getTask(int index) {
        return null;
    }

    @Override
    public Iterator<Task> iterator() {
        return null;
    }
}
