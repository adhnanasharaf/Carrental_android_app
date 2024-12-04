package com.example.carrentalapp.Database;
import android.content.Context; // Add this import
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.carrentalapp.Converter.Converter;
import com.example.carrentalapp.Model.Administrator;
import com.example.carrentalapp.Model.Billing;
import com.example.carrentalapp.Model.Booking;
import com.example.carrentalapp.Model.Customer;
import com.example.carrentalapp.Model.Insurance;
import com.example.carrentalapp.Model.Payment;
import com.example.carrentalapp.Model.Vehicle;
import com.example.carrentalapp.Model.VehicleCategory;


@Database(entities = {Customer.class,       VehicleCategory.class,  Vehicle.class,
                      Administrator.class,  Billing.class,          Booking.class,
                      Insurance.class,      Payment.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class Project_Database extends RoomDatabase {
    public abstract CustomerDao customerDao();
    public abstract VehicleCategoryDao vehicleCategoryDao();
    public abstract VehicleDao vehicleDao();
    public abstract AdministratorDao administratorDao();
    public abstract BillingDao billingDao();
    public abstract BookingDao bookingDao();
    public abstract InsuranceDao insuranceDao();
    public abstract PaymentDao paymentDao();


    private static volatile Project_Database INSTANCE;

    public static Project_Database getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (Project_Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    Project_Database.class, "car_rental_db")
                            .fallbackToDestructiveMigration() // Handle migrations
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

