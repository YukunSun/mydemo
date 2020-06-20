package flight;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/6/20 16:57
 * Blog: bengle.me
 */
public class FlightTest {
    private List<Flight> flights = flights();

    @Test
    public void parseTime() {
        LocalTime time = parseTime("15:30");
        Assert.assertTrue(time.getHour() == 15);
        Assert.assertTrue(time.getMinute() == 30);
        Assert.assertTrue(time.isBefore(parseTime("16:30")));
        Assert.assertTrue(time.isAfter(parseTime("15:18")));
    }

    @Test
    public void solution() {
        //生成足够的飞机，最差的情况是一个航班分配一架飞机
        List<Plane> planes = IntStream.range(1, flights.size()).mapToObj(i -> new Plane("F" + i, new ArrayList<>())).collect(Collectors.toList());
        List<Flight> copy = flights;
        while (copy.size() > 0) {
            for (Plane plane : planes) {
                if (!plane.isCanBeScheduled()) {
                    continue;
                }
                Iterator<Flight> iterator = copy.iterator();
                while (iterator.hasNext()) {
                    Flight flight = iterator.next();
                    List<Flight> scheduled = plane.getFlights();
                    if (scheduled == null || scheduled.isEmpty()) {
                        //直接分配
                        plane.scheduleFlight(flight);
                        iterator.remove();
                    } else {
                        Flight firstScheduledFlight = scheduled.get(0);
                        Flight lastScheduledFlight = scheduled.get(scheduled.size() - 1);
                        if (flight.getOffAirport().equals(lastScheduledFlight.getLandAirport())
                                && flight.getOffTime().isAfter(lastScheduledFlight.getLandTime().plusHours(Plane.FIX_HOURS))) {
                            //fail fast
                            if (firstScheduledFlight.getOffAirport().equals(flight.getLandAirport())) {
                                plane.scheduleFlight(flight);
                                iterator.remove();
                            }
                        }
                    }
                }
            }
        }
        List<Plane> scheduled = planes.stream()
                .filter(plane -> plane.getFlights().size() > 0)
                .collect(Collectors.toList());
        System.out.println(scheduled);
    }

    /**
     * init
     *
     * @return
     */
    private List<Flight> flights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("CA1609", parseTime("07:30"), "首都国际机场", "长春龙嘉国际机场", parseTime("09:15")));
        flights.add(new Flight("CA1601", parseTime("07:35"), "首都国际机场", "桃仙机场", parseTime("08:45")));
        flights.add(new Flight("CA1662", parseTime("08:00"), "长春龙嘉国际机场", "首都国际机场", parseTime("09:50")));
        flights.add(new Flight("CA1654", parseTime("08:30"), "桃仙机场", "首都国际机场", parseTime("09:55")));
        flights.add(new Flight("CA1651", parseTime("08:50"), "首都国际机场", "桃仙机场", parseTime("10:00")));
        flights.add(new Flight("CA953", parseTime("08:55"), "首都国际机场", "周水子机场", parseTime("10:20")));
        flights.add(new Flight("CA1649", parseTime("09:15"), "首都国际机场", "长春龙嘉国际机场", parseTime("11:05")));
        flights.add(new Flight("CA931", parseTime("09:45"), "桃仙机场", "首都国际机场", parseTime("11:00")));
        flights.add(new Flight("CA1605", parseTime("10:30"), "首都国际机场", "周水子机场", parseTime("11:55")));
        flights.add(new Flight("CA1610", parseTime("10:45"), "长春龙嘉国际机场", "首都国际机场", parseTime("12:35")));
        flights.add(new Flight("CA1652", parseTime("11:00"), "桃仙机场", "首都国际机场", parseTime("12:25")));
        flights.add(new Flight("CA1645", parseTime("11:40"), "首都国际机场", "桃仙机场", parseTime("12:55")));
        flights.add(new Flight("CA1641", parseTime("11:50"), "首都国际机场", "周水子机场", parseTime("13:10")));
        flights.add(new Flight("CA1650", parseTime("12:10"), "长春龙嘉国际机场", "首都国际机场", parseTime("13:50")));
        flights.add(new Flight("CA932", parseTime("13:50"), "首都国际机场", "桃仙机场", parseTime("15:00")));
        flights.add(new Flight("CA1646", parseTime("13:55"), "桃仙机场", "首都国际机场", parseTime("15:20")));
        flights.add(new Flight("CA1642", parseTime("14:15"), "周水子机场", "首都国际机场", parseTime("15:25")));
        flights.add(new Flight("CA1664", parseTime("14:45"), "长春龙嘉国际机场", "首都国际机场", parseTime("16:35")));
        flights.add(new Flight("CA1608", parseTime("15:55"), "周水子机场", "首都国际机场", parseTime("17:10")));
        flights.add(new Flight("CA1658", parseTime("16:05"), "桃仙机场", "首都国际机场", parseTime("17:30")));
        flights.add(new Flight("CA1635", parseTime("16:25"), "首都国际机场", "桃仙机场", parseTime("17:30")));
        flights.add(new Flight("CA954", parseTime("17:10"), "周水子机场", "首都国际机场", parseTime("18:30")));
        flights.add(new Flight("CA1625", parseTime("18:05"), "首都国际机场", "桃仙机场", parseTime("19:15")));
        flights.add(new Flight("CA1630", parseTime("18:10"), "长春龙嘉国际机场", "首都国际机场", parseTime("19:55")));
        flights.add(new Flight("CA1636", parseTime("18:30"), "桃仙机场", "首都国际机场", parseTime("19:55")));
        flights.add(new Flight("CA1647", parseTime("19:05"), "首都国际机场", "长春龙嘉国际机场", parseTime("20:40")));
        flights.add(new Flight("CA1668", parseTime("19:40"), "周水子机场", "首都国际机场", parseTime("20:50")));
        flights.add(new Flight("CA1626", parseTime("20:15"), "桃仙机场", "首都国际机场", parseTime("21:40")));
        flights.add(new Flight("CA1661", parseTime("20:25"), "首都国际机场", "长春龙嘉国际机场", parseTime("22:05")));
        flights.add(new Flight("CA1699", parseTime("20:30"), "首都国际机场", "周水子机场", parseTime("21:45")));
        flights.add(new Flight("CA1653", parseTime("21:20"), "首都国际机场", "桃仙机场", parseTime("22:30")));
        flights.add(new Flight("CA1648", parseTime("21:30"), "长春龙嘉国际机场", "首都国际机场", parseTime("23:25")));
        return flights;
    }

    /**
     * parse time
     *
     * @param hhmmTime
     * @return
     */
    private LocalTime parseTime(String hhmmTime) {
        return LocalTime.parse(hhmmTime, DateTimeFormatter.ofPattern("HH:mm"));
    }
}

