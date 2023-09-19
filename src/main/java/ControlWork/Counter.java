package ControlWork;

class Counter implements AutoCloseable {
    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        if (count > 0) {
            throw new IllegalStateException("Счетчик не был сброшен");
        }
    }
}