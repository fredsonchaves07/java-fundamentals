package exceptions.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long difDuration = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(difDuration, TimeUnit.MICROSECONDS);
    }

    public void updateDate(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Reservation: " +
                "Room " + roomNumber +
                ", checkin: " + simpleDateFormat.format(checkin) +
                ", checkout: " + simpleDateFormat.format(checkout) +
                ", " + duration() +
                " nights";
    }
}
