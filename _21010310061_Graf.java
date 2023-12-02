package _21010310061_Ozlem_Cetinkaya;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _21010310061_Graf {


    HashMap<String, String> cities = new HashMap<>();
    int[][] cities_distances;
    ArrayList<_21010310061_Person> persons = new ArrayList<>();

    public void reading_File() throws FileNotFoundException {

        File file = new File("_21010310061_Ozlem_Cetinkaya/Bilgiler.txt");
        Scanner scan = new Scanner(file, "UTF-8");
        String line = "";
        scan.nextLine();

        while (!line.equals("Graf:")) {

            line = scan.nextLine();

            if (line.equals("Graf:")) {
                break;
            }
            String[] parts = line.split(" ");
            cities.put(parts[0], parts[1]);

        }
        cities_distances = new int[cities.size()][cities.size()];
        line = scan.nextLine();

        while (!line.equals("Kişiler ve Başlangıç Noktaları:")) {

            line = scan.nextLine();
            if (line.equals("Kişiler ve Başlangıç Noktaları:")) {
                break;
            }

            String[] parts = line.split("\\s+");

            for (int i = 0; i < cities.size(); i++) {

                int city = Integer.parseInt(parts[0]);

                cities_distances[city - 1][i] = Integer.parseInt(parts[i + 1]);

            }
        }
        while (!line.equals("Kişilerin Seyahat Noktaları ve Hızları:")) {
            line = scan.nextLine();
        }

        while (scan.hasNextLine()) {

            line = scan.nextLine();

            line = line.replace("km/dk", "").replace(",", ".");

            String[] parts = line.split(" ");
            String name = parts[0];
            String route = parts[1];
            double speed = Double.parseDouble(parts[2]);

            _21010310061_Person person = new _21010310061_Person(name, route, speed);

            persons.add(person);


        }

    }
    public void find_Location() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kimin hangi saat itibariyle hangi noktada olduğunu"
                + " hesaplamak için, aralarında bir boşluk bırakarak kişi ismini ve saati giriniz:");
        String line = scan.nextLine();

        String name = line.split(" ")[0];
        String time = line.split(" ")[1];
        int time_started = 8;
        int time_traveled = Math.abs(time_started -  Integer.parseInt(time.substring(0,2))) ;

        boolean flag = false;
        _21010310061_Person person = null;

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).name.equals(name)) {
                flag = true;
                person = persons.get(i);
                break;
            }
        }

        if (flag != true) {
            return;
        } else {

            int road_distance = 0;

            for (int i = 1; i < person.route.length; i++) {

                int city = Integer.parseInt(cities.get(person.route[i - 1]));
                int city2 = Integer.parseInt(cities.get(person.route[i]));
                road_distance += cities_distances[city - 1][city2 - 1];

            }

            int time_sum = (int)(road_distance / (person.speed * 60)) ;
            int distance_traveled = (int)(time_traveled * person.speed*60);

            if (time_sum <= time_traveled) {
                System.out.println(person.route[person.route.length-1]);
                return;
            }



            int distance_cities = 0;
            for (int i = 1; i < person.route.length; i++) {

                int city = Integer.parseInt(cities.get(person.route[i - 1]));
                int city2 = Integer.parseInt(cities.get(person.route[i]));
                distance_cities = cities_distances[city-1][city2-1];
                int time_of_distance = (int)(distance_cities / (person.speed * 60));
                if (time_of_distance >= time_traveled) {
                    System.out.println(person.name + " saat " + time  +" itibariyle "+  person.route[i - 1] + " " +person.route[i] + " arasındadır" );
                    return;
                }

                time_traveled = time_of_distance - time_traveled;

            }


        }


    }

    public void is_There_A_Road() {

        Scanner scan = new Scanner(System.in);
        System.out.println("İki şehir arasında direkt yol olup olmadığını sorgulamak için şehir"
                + " isimlerini aralarında bir boşluk bırakarak giriniz:");
        String line = scan.nextLine();
        String city1 = line.split(" ")[0];
        String city2 = line.split(" ")[1];

        int city1_value = Integer.parseInt(cities.get(city1));
        int city2_value = Integer.parseInt(cities.get(city2));


        if(cities_distances[city1_value-1][city2_value-1] != 0) {
            System.out.println(city1 + " ve " + city2 + " arasında direkt yol var");
        }else {
            System.out.println(city1 + " ve " + city2 + " arasında direkt yol yok");

        }

    }

    public void road_Distance() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Toplam yol uzunluğu hesaplanacak olan kişinin adını giriniz: ");
        String name = scan.nextLine();

        boolean flag = false;
        _21010310061_Person person = null;

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).name.equals(name)) {
                flag = true;
                person = persons.get(i);
                break;
            }
        }




        if (flag != true) {
            return;
        } else {

            int road_distance = 0;

            for (int i = 1; i < person.route.length; i++) {

                int city = Integer.parseInt(cities.get(person.route[i - 1]));
                int city2 = Integer.parseInt(cities.get(person.route[i]));
                road_distance += cities_distances[city - 1][city2 - 1];

            }
            System.out.println(person.name + " toplam yol uzunluğu = " + road_distance + " km");

        }
    }

    public void arrival_Time() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Varış süresi hesaplanacak olan kişinin adını girin: ");
        String name = scan.nextLine();
        boolean flag = false;
        _21010310061_Person person = null;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).name.equals(name)) {
                flag = true;
                person = persons.get(i);
                break;
            }
        }

        if (flag != true) {
            return;
        } else {

            int road_distance = 0;

            for (int i = 1; i < person.route.length; i++) {

                int city = Integer.parseInt(cities.get(person.route[i - 1]));
                int city2 = Integer.parseInt(cities.get(person.route[i]));
                road_distance += cities_distances[city - 1][city2 - 1];

            }

            double arrival_time = (road_distance / person.speed);
            System.out.println(person.name + " " + person.route[person.route.length - 1] + " varış süresi = " + " "
                    + (int)arrival_time + " dk");
        }

    }

}
