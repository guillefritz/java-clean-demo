package ar.javaclean.action;

import ar.javaclean.dataprovider.TicketDataProvider;
import ar.javaclean.model.Seat;
import ar.javaclean.model.ShowSchedule;
import ar.javaclean.model.Ticket;

public class BuyTicketAction {

    private final TicketDataProvider ticketDataProvider;

    public BuyTicketAction(TicketDataProvider ticketDataProvider) {
        this.ticketDataProvider = ticketDataProvider;
    }

    public Ticket buyTicket(ShowSchedule showSchedule, Seat seat) {
        Ticket foundTicket = ticketDataProvider.findByShowScheduleAndSeat(showSchedule, seat);
        if(foundTicket==null) {
            Ticket ticket = new Ticket(showSchedule, seat);
            return ticketDataProvider.save(ticket);
        } else {
            //TODO: log + use functional entities (vavr)
            return null;
        }
    }

}
