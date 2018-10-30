package izo809.chap6;

public class JammedTurkeyCage implements AutoCloseable {
    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkeys in");
            throw new IllegalStateException("turkeys ran off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());

            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage());
        }
    }

    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
}
