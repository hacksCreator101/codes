        positionTextView = findViewById(R.id.positionTextView);
        Button fallButton = findViewById(R.id.fallButton);
        Button safeButton = findViewById(R.id.safeButton);

        // Simulate fall
        fallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerY -= 10;  // Decrease Y position
                checkVoid();  // Check if the player has fallen into the void
                updatePosition();
            }
        });

        // Return to safe zone
        safeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerY = SAFE_ZONE_Y;  // Reset to safe zone
                updatePosition();
            }
        });
    }

    // Check if the player has fallen into the void
    private void checkVoid() {
        if (playerY <= VOID_THRESHOLD) {
            playerY = SAFE_ZONE_Y;  // Reset to safe zone
        }
    }

    // Update the position display
    private void updatePosition() {
        positionTextView.setText("Player Position: Y = " + playerY);
    }
}
