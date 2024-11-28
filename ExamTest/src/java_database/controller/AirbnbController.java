package java_database.controller;

import java_database.repository.ApartmentRepository;
import java_database.view.Airbnb;

public class AirbnbController {


    public AirbnbController(){
        ApartmentRepository apartmentRepository = new ApartmentRepository();

        Airbnb airbnb = new Airbnb(apartmentRepository);
        airbnb.setVisible(true);
    }



}
