package ar.javaclean.dataprovider;

import ar.javaclean.model.Seat;
import ar.javaclean.model.ShowSchedule;
import ar.javaclean.model.Ticket;

public interface TicketDataProvider {

    Ticket findByShowScheduleAndSeat(ShowSchedule showSchedule, Seat seat);
    Ticket save(Ticket ticket);
}
