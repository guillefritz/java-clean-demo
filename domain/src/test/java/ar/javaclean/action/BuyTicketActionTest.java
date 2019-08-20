package ar.javaclean.action;

import ar.javaclean.dataprovider.TicketDataProvider;
import ar.javaclean.model.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BuyTicketActionTest {

    @Test
    public void shouldBuyATicket() {
        //given
        Room room = new Room();
        room.setId(4L);
        room.setNumber(2);
        room.setType("NORMAL");
        room.setDescription("Room 2");

        Movie movie = new Movie();
        movie.setId(4L);
        movie.setName("Shark");
        movie.setDuration(Duration.ofMinutes(55));

        Seat seat = new Seat();
        seat.setId(10L);
        seat.setNumber(7);
        seat.setType("NORMAL");

        ShowSeat showSeat = new ShowSeat(seat, true);

        ShowSchedule showSchedule = new ShowSchedule();
        showSchedule.setId(22L);
        showSchedule.setStart(LocalDateTime.now());
        showSchedule.setEnd(LocalDateTime.now().plus(Duration.ofHours(1)));
        showSchedule.setRoom(room);
        showSchedule.setMovie(movie);
        showSchedule.setShowSeats(Collections.singletonList(showSeat));

        Ticket ticketSaved = new Ticket(1L, showSchedule, showSeat);
        ArgumentCaptor<Ticket> ticketArgumentCaptor = ArgumentCaptor.forClass(Ticket.class);

        TicketDataProvider ticketDataProvider = mock(TicketDataProvider.class);
        when(ticketDataProvider.findByShowScheduleAndSeat(any(), any())).thenReturn(null);
        when(ticketDataProvider.save(ticketArgumentCaptor.capture())).thenReturn(ticketSaved);
        BuyTicketAction buyTicketAction = new BuyTicketAction(ticketDataProvider);

        //when
        Ticket ticket = buyTicketAction.buyTicket(showSchedule, seat);

        //then
        assertThat(ticket).isNotNull();
        verify(ticketDataProvider).findByShowScheduleAndSeat(showSchedule, seat);
        verify(ticketDataProvider).save(ticketArgumentCaptor.getValue());
    }
}
