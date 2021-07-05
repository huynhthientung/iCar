package com.example.icar.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.icar.R;
import com.example.icar.model.Tracking;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private String bookingKey;
    private ListView listView;
    private ArrayList<String> trackingArrayList;
    private ArrayAdapter adapter;
    private DatabaseReference root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bookingKey = getIntent().getExtras().getString("BOOKING_KEY");
        Toast.makeText(this, "" + bookingKey, Toast.LENGTH_SHORT).show();
        root = FirebaseDatabase.getInstance().getReference();
        trackingArrayList = new ArrayList<>();
        listView = findViewById(R.id.listView_Tracking);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, trackingArrayList);
        listView.setAdapter(adapter);
        root.child("Tracking").child(bookingKey).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                Tracking tracking = snapshot.getValue(Tracking.class);
                trackingArrayList.add(tracking.date + ": " + tracking.location);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}