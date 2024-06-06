package com.example.room;

import androidx.room.Database;
import androidx.room.Room;

import android.content.Context;

@Database(entities = {Course.class}, version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    private static RoomDatabase instance;

    public abstract CourseDao courseDao();

    public static synchronized RoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, "course_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

