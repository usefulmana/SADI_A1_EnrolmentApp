package SADI.Command;

public interface Command {
    public void executeEnrol();
    public void undoEnrol();
    public void executeDrop();
    public void undoDrop();
}
