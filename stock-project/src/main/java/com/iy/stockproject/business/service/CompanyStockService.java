package com.iy.stockproject.business.service;

import com.iy.stockproject.data.entity.Company;
import com.iy.stockproject.data.entity.Stock;
import com.iy.stockproject.data.repository.CompanyRepository;
import com.iy.stockproject.data.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyStockService {
    private CompanyRepository companyRepository;
    private StockRepository stockRepository;

    //TODO: get data from TD API

    //TODO: get Company Stock data together as one method
//    public List<RoomReservation> getRoomReservationsForDate(Date date){
//        Iterable<Room> rooms = this.roomRepository.findAll();
//        Map<Long, RoomReservation> roomReservationMap = new HashMap();
//        rooms.forEach(room -> {
//            RoomReservation roomReservation = new RoomReservation();
//            roomReservation.setRoomId(room.getRoomId());
//            roomReservation.setRoomName(room.getRoomName());
//            roomReservation.setRoomNumber(room.getRoomNumber());
//            roomReservationMap.put(room.getRoomId(), roomReservation);
//        });
//        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
//        reservations.forEach(reservation -> {
//            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
//            roomReservation.setDate(date);
//            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
//            roomReservation.setFirstName(guest.getFirstName());
//            roomReservation.setLastName(guest.getLastName());
//            roomReservation.setGuestId(guest.getGuestId());
//        });
//        List<RoomReservation> roomReservations = new ArrayList<>();
//        for(Long id: roomReservationMap.keySet()){
//            roomReservations.add(roomReservationMap.get(id));
//        }
//        roomReservations.sort(new Comparator<RoomReservation>() {
//            @Override
//            public int compare(RoomReservation o1, RoomReservation o2) {
//                if (o1.getRoomName() == o2.getRoomName()){
//                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
//                }
//                return o1.getRoomName().compareTo(o2.getRoomName());
//            }
//        });
//        return roomReservations;
//    }

    public List<Company> getCompanies() {
        Iterable<Company> companies = this.companyRepository.findAll();
        List<Company> companyList = new ArrayList<>();
        companies.forEach(company -> {
            companyList.add(company);
        });
        return companyList;
    }

    public List<Stock> getStocks() {
        Iterable<Stock> stocks = this.stockRepository.findAll();
        List<Stock> stockList = new ArrayList<>();
        stocks.forEach(stock -> {
            stockList.add(stock);
        });
        return stockList;
    }
}
