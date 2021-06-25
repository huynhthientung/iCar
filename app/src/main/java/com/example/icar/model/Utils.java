package com.example.icar.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static ArrayList<Customer> customerArrayList;
    private static ArrayList<Service> serviceArrayList;
    private static ArrayList<ExtraService> extraServiceArrayList;
    private FirebaseDatabase root;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

    private Utils() {
        if (null == customerArrayList) {
            customerArrayList = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        //TODO: handle later
    }

    private static Utils getInstance() {
        if (null == instance) {
            instance = new Utils();
        }
        return instance;
    }
}
