package net.coderdaily.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/9/15 23:14
 * Blog: bengle.me
 */
public class CompareTest {

    @Test
    public void comparableTest() {
        List<Player> footballTeam = new ArrayList<>();
        Player player3 = new Player(45, "Steven", 24);
        Player player2 = new Player(67, "Roger", 22);
        Player player1 = new Player(59, "John", 20);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("before order:" + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("after order:" + footballTeam);
    }


    @Test
    public void comparatorTest() {
        List<Student> footballTeam = new ArrayList<>();
        Student player3 = new Student(45, "Steven", 24);
        Student player2 = new Student(67, "Roger", 22);
        Student player1 = new Student(59, "John", 20);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("before order:" + footballTeam);
        Collections.sort(footballTeam, new StudentAgeComparator());
        System.out.println("after order:" + footballTeam);
    }

    @Test
    public void comparatorJava8Test() {
        //进化路径
        Comparator<Student> byAge = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        Comparator<Student> byAge2 = (Student o1, Student o2) -> Integer.compare(o1.getAge(), o2.getAge());
        Comparator<Student> byAge3 = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
        Comparator<Student> byAge4 = Comparator.comparingInt(stu -> stu.getAge());
        Comparator<Student> byAge5 = Comparator.comparingInt(Student::getAge);
        //eg
        List<Student> footballTeam = new ArrayList<>();
        Student player3 = new Student(45, "Steven", 24);
        Student player2 = new Student(67, "Roger", 22);
        Student player1 = new Student(59, "John", 20);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("before order:" + footballTeam);
        footballTeam.sort(byAge5);
        System.out.println("after order:" + footballTeam);
    }

    @Test
    public void mutiComparatorJava8Test() {
        Comparator<Student> byAge = Comparator.comparingInt(Student::getAge);
        Comparator<Student> byRanking = Comparator.comparingInt(Student::getRanking);
        //eg
        List<Student> footballTeam = new ArrayList<>();
        Student player3 = new Student(45, "Steven", 24);
        Student player2 = new Student(67, "Roger", 22);
        Student player1 = new Student(59, "John", 20);
        Student player4 = new Student(59, "Foo", 31);
        Student player5 = new Student(59, "Bar", 10);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        footballTeam.add(player4);
        footballTeam.add(player5);

        System.out.println("before order:" + footballTeam);
        footballTeam.sort(byAge.thenComparing(byRanking));
        System.out.println("after order:" + footballTeam);
    }
}

class Player implements Comparable<Player> {
    private int age;
    private String name;
    private int ranking;

    public Player(int age, String name, int ranking) {
        this.age = age;
        this.name = name;
        this.ranking = ranking;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", ranking=" + ranking +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}

class Student {
    private int age;
    private String name;
    private int ranking;

    public Student(int age, String name, int ranking) {
        this.age = age;
        this.name = name;
        this.ranking = ranking;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}

class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}