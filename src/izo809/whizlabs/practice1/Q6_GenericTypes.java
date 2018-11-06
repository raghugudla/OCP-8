package izo809.whizlabs.practice1;


public class Q6_GenericTypes<T, S> {
    private T t;
    private S s;

    private Q6_GenericTypes(T t, S s) {

        this.t = t;
        this.s = s;
    }

    public static <U> Q6_GenericTypes<U, U> createTask(U u) {
        return new Q6_GenericTypes(u, u);
    }

    public static void main(String[] args) {
        Q6_GenericTypes<String, String> obj = Q6_GenericTypes.createTask("");

        Q6_GenericTypes obj1 = new Q6_GenericTypes("", ""); // Raw Type
        Q6_GenericTypes<?, ?> obj2 = new Q6_GenericTypes("", "");
        Q6_GenericTypes<?, ?> obj3 = new Q6_GenericTypes<>("", "");
        Q6_GenericTypes<Object, ?> obj4 = new Q6_GenericTypes("", "");
        Q6_GenericTypes<Object, String> obj5 = new Q6_GenericTypes<>("", "");
        new Q6_GenericTypes<>("", "");
    }
}
