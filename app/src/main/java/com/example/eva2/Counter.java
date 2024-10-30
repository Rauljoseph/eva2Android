package com.example.eva2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Counter extends AppCompatActivity {
    private int quantity = 1;
    private final int pricePerUnit = 1290;
    private TextView quantityText, totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        quantityText = findViewById(R.id.quantity);
        totalAmount = findViewById(R.id.totalAmount);
        ImageView addButton = findViewById(R.id.addButton);
        ImageView removeButton = findViewById(R.id.removeButton);
        Button addToCartButton = findViewById(R.id.addToCartButton);

        addButton.setOnClickListener(v -> updateQuantity(1));
        removeButton.setOnClickListener(v -> updateQuantity(-1));

        addToCartButton.setOnClickListener(v -> {
            // Lógica para agregar al carrito
        });
    }

    private void updateQuantity(int change) {
        quantity = Math.max(1, quantity + change);
        quantityText.setText(String.valueOf(quantity));
        totalAmount.setText("$" + (quantity * pricePerUnit));
    }
}