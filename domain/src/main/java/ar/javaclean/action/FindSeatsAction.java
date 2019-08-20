package ar.javaclean.action;

import ar.javaclean.dataprovider.ShowScheduleDataProvider;
import ar.javaclean.model.Seat;
import ar.javaclean.model.ShowSchedule;
import ar.javaclean.model.ShowSeat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindSeatsAction {

    private final ShowScheduleDataProvider showScheduleDataProvider;

    public FindSeatsAction(ShowScheduleDataProvider showScheduleDataProvider) {
        this.showScheduleDataProvider = showScheduleDataProvider;
    }

    public List<Seat> findAvailableSeatsForAShowSchedule(ShowSchedule showSchedule) {
        ShowSchedule showScheduleFound = showScheduleDataProvider.findById(showSchedule.getId());
        if(showScheduleFound!=null) {
            return showScheduleFound.getShowSeats().stream()
                    .filter(ShowSeat::getAvailable)
                    .map(ShowSeat::getSeat)
                    .collect(Collectors.toList());
        } else {
            //TODO: log
            return new ArrayList<>();
        }
    }
}
