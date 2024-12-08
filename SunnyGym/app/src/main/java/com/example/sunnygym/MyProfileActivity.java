package com.example.sunnygym;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

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
        PopupMenu popupMenu = new PopupMenu(MyProfileActivity.this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.profile_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(MyProfileActivity.this, UserProfileActivity.class));
                    return true;
                } else if (itemId == R.id.my_profile) {
                    startActivity(new Intent(MyProfileActivity.this, MyProfileActivity.class));
                    return true;
                } else if (itemId == R.id.guided_activities) {
                    startActivity(new Intent(MyProfileActivity.this, GuidedActivitiesActivity.class));
                    return true;
                } else if (itemId == R.id.view_clubs) {
                    startActivity(new Intent(MyProfileActivity.this, ViewClubsActivity.class));
                    return true;
                } else if (itemId == R.id.support) {
                    startActivity(new Intent(MyProfileActivity.this, SupportActivity.class));
                    return true;
                } else if (itemId == R.id.logout) {
                    startActivity(new Intent(MyProfileActivity.this, MainActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();

    }
}