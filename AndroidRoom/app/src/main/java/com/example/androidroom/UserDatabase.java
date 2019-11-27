package com.example.androidroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 4)
public abstract class UserDatabase extends RoomDatabase {
    abstract UserDao1 userDao();
}
