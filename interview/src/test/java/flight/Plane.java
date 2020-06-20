package flight;

import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/6/20 17:56
 * Blog: bengle.me
 */
public class Plane {
    /**
     * 最多允许飞行的航班
     */
    public static final int MAX_PERMIT_FLIGHTS = 2;
    /**
     * 检修时间
     */
    public static final int FIX_HOURS = 1;


    private String planeId;
    private List<Flight> flights;

    public Plane() {
    }

    public Plane(String planeId) {
        this.planeId = planeId;
    }

    public Plane(String planeId, List<Flight> flights) {
        this.planeId = planeId;
        this.flights = flights;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId='" + planeId + '\'' +
                ", flights=" + flights +
                '}';
    }

    /**
     * 给飞机安排航班
     *
     * @param flight
     * @return
     */
    public boolean scheduleFlight(Flight flight) {
        if (!isCanBeScheduled()) {
            throw new IllegalStateException("current plane cannot be scheduled flight anymore");
        }
        return flights.add(flight);
    }

    /**
     * 该飞机是否还能继续被排班
     *
     * @return
     */
    public boolean isCanBeScheduled() {
        if (flights != null && flights.size() >= MAX_PERMIT_FLIGHTS) {
            return false;
        }
        return true;
    }
}
