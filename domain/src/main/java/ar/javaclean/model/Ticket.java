package ar.javaclean.model;

public class Ticket {

    private Long id;
    private ShowSchedule showSchedule;
    private ShowSeat showSeat;

    public Ticket() {
    }

    public Ticket(Long id, ShowSchedule showSchedule, ShowSeat showSeat) {
        this.id = id;
        this.showSchedule = showSchedule;
        this.showSeat = showSeat;
    }

    public Ticket(ShowSchedule showSchedule, Seat seat) {
        this.showSchedule = showSchedule;
        this.showSeat = new ShowSeat(seat, false);
    }

    public ShowSchedule getShowSchedule() {
        return showSchedule;
    }

    public void setShowSchedule(ShowSchedule showSchedule) {
        this.showSchedule = showSchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (showSchedule != null ? !showSchedule.equals(ticket.showSchedule) : ticket.showSchedule != null)
            return false;
        return showSeat != null ? showSeat.equals(ticket.showSeat) : ticket.showSeat == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (showSchedule != null ? showSchedule.hashCode() : 0);
        result = 31 * result + (showSeat != null ? showSeat.hashCode() : 0);
        return result;
    }
}
