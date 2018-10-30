package izo809.chap4;

public class FunctionalInterfaceEx {
    String walk = "walk";

    public static void main(String[] args) {
        new FunctionalInterfaceEx().everyonePlay(true);
        System.out.println("-------");
        new FunctionalInterfaceEx().everyonePlay(false);
    }

    void everyonePlay(boolean baby) {
        String approach = "amble";
        //approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);

        //approach = "run";
    }

    void play(Gorilla g) {
        System.out.println(g.move());
    }

}
