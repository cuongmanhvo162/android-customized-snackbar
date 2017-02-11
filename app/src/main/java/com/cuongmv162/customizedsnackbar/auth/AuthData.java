package com.cuongmv162.customizedsnackbar.auth;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cuongmv162 on 1/28/2017.
 */

public class AuthData implements Parcelable {

    private String email;
    private String username;
    private String password;

    protected AuthData(Parcel in) {
        email = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public AuthData() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AuthData> CREATOR = new Creator<AuthData>() {
        @Override
        public AuthData createFromParcel(Parcel in) {
            return new AuthData(in);
        }

        @Override
        public AuthData[] newArray(int size) {
            return new AuthData[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
