package ar.javaclean.model;

public class ShowSeat {

    private Long id;
    private Seat seat;
    private Boolean available;

    public ShowSeat(Seat seat, Boolean available) {
        this.seat = seat;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowSeat showSeat = (ShowSeat) o;

        if (id != null ? !id.equals(showSeat.id) : showSeat.id != null) return false;
        if (seat != null ? !seat.equals(showSeat.seat) : showSeat.seat != null) return false;
        return available != null ? available.equals(showSeat.available) : showSeat.available == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }
}
