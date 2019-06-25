package hello;

public class Schedule {

    public Schedule() {

    }

    public Schedule(Integer userId, String date, Integer hour, Integer minute, String event, Long timestamp) {
        super();
        this.userId = userId;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.event = event;
        this.timestamp = timestamp;
    }

    private Integer userId;
    private String date;
    private Integer hour;
    private Integer minute;
    private String event;
    private Long timestamp;

    //Getters and setters

    @Override
    public String toString() {
        return "Schedule [id=" + userId + ", date=" + date + ", hour=" + hour +
                ", minute=" + minute + ", event=" + event + ", timestamp=" + timestamp + "]";
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public String getEvent() {
        return event;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
