


## Entities

    movie
        name
        duration

    room
        seat []
    
    seat
        number
        type
        reservationTicket

    showSchedule
        room
        day
        time
        movie    
        
    ticket
        showSchedule
        seat

## Action / Usecases

    find seats for a showSchedule
    buy ticket
