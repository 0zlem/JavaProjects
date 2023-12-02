package _21010310061_Ozlem_Cetinkaya;

public class _21010310061_Person {



    String name;
    String[] route;
    double speed;

    public _21010310061_Person(String name, String route, double speed) {

        this.name = name;
        this.route = route.split("-");
        this.speed = speed;

    }


}

