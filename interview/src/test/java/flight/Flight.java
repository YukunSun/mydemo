package flight;

import java.time.LocalTime;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/6/20 17:11
 * Blog: bengle.me
 */
public class Flight {
    private String flightId;
    private LocalTime offTime;
    private String offAirport;
    private LocalTime landTime;
    private String landAirport;

    public Flight() {
    }

    public Flight(String flightId, LocalTime offTime, String offAirport, String landAirport, LocalTime landTime) {
        this.flightId = flightId;
        this.offTime = offTime;
        this.offAirport = offAirport;
        this.landTime = landTime;
        this.landAirport = landAirport;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public LocalTime getOffTime() {
        return offTime;
    }

    public void setOffTime(LocalTime offTime) {
        this.offTime = offTime;
    }

    public String getOffAirport() {
        return offAirport;
    }

    public void setOffAirport(String offAirport) {
        this.offAirport = offAirport;
    }

    public LocalTime getLandTime() {
        return landTime;
    }

    public void setLandTime(LocalTime landTime) {
        this.landTime = landTime;
    }

    public String getLandAirport() {
        return landAirport;
    }

    public void setLandAirport(String landAirport) {
        this.landAirport = landAirport;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", offTime=" + offTime +
                ", offAirport='" + offAirport + '\'' +
                ", landTime=" + landTime +
                ", landAirport='" + landAirport + '\'' +
                '}';
    }
}
