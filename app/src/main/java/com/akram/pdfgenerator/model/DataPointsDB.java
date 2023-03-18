package com.akram.pdfgenerator.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = DataPoints.class,version = 1)
public abstract class DataPointsDB extends RoomDatabase {

    public abstract DataPointsDao dataPointsDao();

    public static DataPointsDB instance;

    public static synchronized DataPointsDB getInstance(Context context) {

        if (instance == null){

            instance = Room.databaseBuilder(context,DataPointsDB.class,"graph_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(initialCallBack)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback initialCallBack =
            new RoomDatabase.Callback(){
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    new InitialAsyncTask(instance).execute();
                }
            };

    private static class InitialAsyncTask extends AsyncTask<Void,Void,Void> {

        private DataPointsDao dataPointsDao;

        public InitialAsyncTask(DataPointsDB db) {
            dataPointsDao = db.dataPointsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dataPointsDao.insert(new DataPoints(0,0,
                    1,3,
                    2,4,
                    3,5,
                    0,0,
                    1,2,
                    2,5,
                    3,0));
            dataPointsDao.insert(new DataPoints(0,0,
                    1,2,
                    2,5,
                    3,0,
                    0,0,
                    1,2,
                    2,4,
                    3,5));
            dataPointsDao.insert(new DataPoints(0,0,
                    1,3,
                    2,1,
                    3,3,
                    0,0,
                    1,3,
                    2,3,
                    3,0));
            dataPointsDao.insert(new DataPoints(0,0,
                    1,4,
                    2,3,
                    3,2,
                    0,0,
                    1,2,
                    2,5,
                    3,2));
            return null;
        }
    }
}
