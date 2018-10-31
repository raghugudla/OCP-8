package izo809.chap2;

public interface Child extends Father, Mother {

    //void meth(); Optional to override abstract method inherited from multiple parents

    void deMeth(); // Must override same default methods inherited from multiple parent

    //static void statMeth() {} Optional to override static methods inherited from multiple parent

    //if the same method as default and static in parents, can't override static,
    // but can override the default method
    /*static void mixMeht() {} */

    void mixMeth();

}
