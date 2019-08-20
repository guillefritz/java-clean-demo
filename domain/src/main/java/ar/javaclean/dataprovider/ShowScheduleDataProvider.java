package ar.javaclean.dataprovider;

import ar.javaclean.model.ShowSchedule;

public interface ShowScheduleDataProvider {
    ShowSchedule findById(Long id);
}
