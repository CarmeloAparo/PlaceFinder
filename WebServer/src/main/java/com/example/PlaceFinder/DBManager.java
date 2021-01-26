package com.example.PlaceFinder;

import com.example.PlaceFinder.entity.*;

import java.util.*;

public interface DBManager {

    //void setup();
    void exit();
    User getUser(String username);
    boolean login(String username, String password);
    List<Reservation> browseUserReservations(String userId);
    List<User> findCovidContact (String userId);
    int updateCovidNotification(List<User> userList, boolean newNotification);
    int notifyCovidContact(String userId);
    boolean userReservation(String userid, int slotid, String roomid, Date date);
    boolean professorReservation(String userid, int slotid, String roomid, Date date);
    boolean deleteUserReservation(String userid, int slotid, String roomid, Date date);
    String addRoom(String idRoom, int numSeats, float capacity);
    boolean changeCapacity(String roomid, float capacity);
}
