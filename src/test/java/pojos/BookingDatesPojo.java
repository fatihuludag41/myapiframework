package pojos;

public class BookingDatesPojo {
    private String checkIn;
    private String checkOut;

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }


    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                '}';
    }
}
