package ar.javaclean.model;

import java.time.LocalDateTime;
import java.util.List;

public class ShowSchedule {

    private Long id;
    private Room room;
    private LocalDateTime start;
    private LocalDateTime end;
    private Movie movie;
    private List<ShowSeat> showSeats;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowSchedule that = (ShowSchedule) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
        return showSeats != null ? showSeats.equals(that.showSeats) : that.showSeats == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (showSeats != null ? showSeats.hashCode() : 0);
        return result;
    }
}
