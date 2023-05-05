package com.example.timelychefs;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileActivity extends AppCompatActivity {

    private ImageView mProfileImage;
    private TextView mDisplayName;
    private TextView mAccountId;
    private TextView mEmail;
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mDateJoined;

    private Connection mConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mProfileImage = findViewById(R.id.profile_image);
        mDisplayName = findViewById(R.id.display_name);
        mAccountId = findViewById(R.id.account_id);
        mEmail = findViewById(R.id.email);
        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mDateJoined = findViewById(R.id.date_joined);

        // Get the username and password from the previous activity
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        // Connect to the database using the getConnection() function
        mConnection = getConnection();

        // Query the database for the user's profile information
        try {
            String query = "SELECT picture, displayName, AccountID, email, firstName, lastName, DateJoined FROM accounts WHERE username=? AND password=?";
            PreparedStatement stmt = mConnection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Set the profile information on the activity's views
                mProfileImage.setImageURI(Uri.parse(rs.getString("picture")));
                mDisplayName.setText(rs.getString("displayName"));
                mAccountId.setText(rs.getString("AccountID"));
                mEmail.setText(rs.getString("email"));
                mFirstName.setText(rs.getString("firstName"));
                mLastName.setText(rs.getString("lastName"));
                mDateJoined.setText(rs.getString("DateJoined"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database connection when the activity is destroyed
        try {
            mConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}