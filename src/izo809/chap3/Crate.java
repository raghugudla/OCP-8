package izo809.chap3;

public class Crate<T> {

    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }

    public <U> Crate<U> create(U u) {
        return new Crate<U>();
    }
}