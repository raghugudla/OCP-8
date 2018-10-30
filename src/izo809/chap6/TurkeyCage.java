package izo809.chap6;

public class TurkeyCage implements AutoCloseable {

    public static void main(String[] args) {

        try (TurkeyCage cage = new TurkeyCage();) {
            cage.put();
        }
    }

    private void put() {
        System.out.println("Putting Turkey in cage");
    }

    @Override
    public void close() {
        System.out.println("closing Turkey Cage!");

    }

}
