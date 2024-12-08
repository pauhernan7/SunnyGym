package com.example.sunnygym;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GuidedActivitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided_activities);

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Zumba", R.drawable.zumba_image));
        activities.add(new Activity("Body Combat", R.drawable.body_combat_image));
        activities.add(new Activity("Body Pump", R.drawable.body_pump_image));

        // Configurar RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewActivities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ActivitiesAdapter(this, activities));

        ImageView menuButton = findViewById(R.id.menuButton); // Cambia esto según tu diseño
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    /**
     * Método para mostrar el menú emergente
     *
     * @param anchorView Vista desde la cual se despliega el menú
     */
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(GuidedActivitiesActivity.this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.profile_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(GuidedActivitiesActivity.this, UserProfileActivity.class));
                    return true;
                } else if (itemId == R.id.my_profile) {
                    startActivity(new Intent(GuidedActivitiesActivity.this, MyProfileActivity.class));
                    return true;
                } else if (itemId == R.id.guided_activities) {
                    return true;
                } else if (itemId == R.id.view_clubs) {
                    startActivity(new Intent(GuidedActivitiesActivity.this, ViewClubsActivity.class));
                    return true;
                } else if (itemId == R.id.support) {
                    startActivity(new Intent(GuidedActivitiesActivity.this, SupportActivity.class));
                    return true;
                } else if (itemId == R.id.logout) {
                    startActivity(new Intent(GuidedActivitiesActivity.this, MainActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();


    }
    // Crear lista de actividades

}
