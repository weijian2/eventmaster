package com.example.daniel.eventmaster;

/**
 * Created by daniel on 3/14/18.
 */

public class User {
    private String username;
    private String password;
    private long registerTime;

    public User(final String username, final String password, final long time) {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
        this.username = username;
        this.password = password;
        this.registerTime = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTime() {
        return registerTime;
    }

    public void setTime(long time) {
        this.registerTime = time;
    }
}
