package com.example.adminapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static String DBNAME = "admindb.db";
    public static String TBNAME = "admin";
    public static final int DBVERSION = 1;

    String col1 = "username";
    String col2 = "password";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "CREATE TABLE IF NOT EXISTS '"+TBNAME+"' ( '"+col1+"' VARCHAR(20) PRIMARY KEY, '"+col2+"' VARCHAR(20))";
        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBNAME);
        onCreate(db);
    }

    public int checkUser(AdminModel admin){
        SQLiteDatabase db = this.getReadableDatabase();
        String check = "SELECT * FROM "+TBNAME+" WHERE "+col1+" = '"+admin.getUsername()+"' AND "+col2+" = '"+admin.getPassword()+"'";
        System.out.println(check);
        Cursor cursor;
        cursor = db.rawQuery(check,null);
        if(cursor.getCount() == 0){
            //db.close();
            System.out.println("failed!!");
            return -1;
        }
        else{
            return 0;
        }
        //db.close();
    }

    public long insertUser(AdminModel admin){
        SQLiteDatabase db = this.getWritableDatabase();
        String check = "SELECT * FROM "+TBNAME+" WHERE "+col1+" = '"+admin.getUsername()+"'";
        Cursor cursor;
        cursor = db.rawQuery(check,null);
        long r;
        if(cursor.getCount() == 0){
            System.out.println("Here!");
            ContentValues cv = new ContentValues();
            cv.put(col1,admin.getUsername());
            cv.put(col2,admin.getPassword());
            r = db.insert(TBNAME,null,cv);
        }
        else{
            r =  -1;
        }
        //db.close();
        cursor.close();
        return r;

    }
    public int deleteUser(AdminModel admin) {
        SQLiteDatabase db = this.getWritableDatabase();
        String check = "SELECT * FROM "+TBNAME+" WHERE "+col1+" = '"+admin.getUsername()+"'";
        Cursor cursor = null;
        cursor = db.rawQuery(check,null);
        if(cursor.getCount() == 0){
            //db.close();
            cursor.close();
            return -1;
        }
        db.delete(TBNAME, col1 + "=?", new String[]{String.valueOf(admin.getUsername())});
        //db.close();
        return 0;
    }

    public int updateUser(AdminModel admin1, AdminModel admin2){
        SQLiteDatabase db = this.getWritableDatabase();
        String check = "SELECT * FROM "+TBNAME+" WHERE "+col1+" = '"+admin1.getUsername()+"'";
        Cursor cursor = null;
        cursor = db.rawQuery(check,null);
        if(cursor.getCount() == 0){
            //db.close();
            cursor.close();
            return -1;
        }
        cursor.close();
        db.execSQL("UPDATE "+TBNAME+" SET "+col2+" = '"+admin2.getPassword()+"' WHERE "+col1+" = '"+admin1.getUsername()+"'");
        System.out.println("UPDATE "+TBNAME+" SET "+col2+" = '"+admin2.getPassword()+"' WHERE "+col1+" = '"+admin1.getUsername()+"'");
        //db.close();
        return 0;
    }

    public String display(){
        SQLiteDatabase db = this.getReadableDatabase() ;
        Cursor cur = db.rawQuery("SELECT * FROM "+TBNAME,null);
        String finalres =" ";
        while(cur.moveToNext()){
            finalres += cur.getString(0)+" : "+cur.getString(1)+"\n";
        }
        return finalres ;
    }
}
