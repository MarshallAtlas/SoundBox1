package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.dao

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.security.identity.AccessControlProfileId
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.album
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import kotlinx.coroutines.selects.select
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.dao.databaseHandler

interface albumDAO{
    fun addAlbum(album: album)
    fun removeAlbum(albumId: Int)
    fun getAlbum() : ArrayList<album>
    fun updateAlbum(album: album)
}

class albumDAOSQLiteImplementation(var context: Context) : albumDAO{

    override fun addAlbum(album: album) {
        TODO("Not yet implemented")
    }

    override fun removeAlbum(albumId: Int) {
        TODO("Not yet implemented")
    }

    override fun getAlbum(): ArrayList<album> {
        val albumList : ArrayList<album> = ArrayList()
        val selectQuery = "SELECT ${databaseHandler.tableAlbumName}, ${databaseHandler.tableAlbumArtist} FROM ${databaseHandler.tableAlbum}"


        val DatabaseHandler = databaseHandler(context)
        val db = DatabaseHandler.readableDatabase // query only so readable
        var cursor = db.rawQuery(selectQuery, null)

        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLException){
            db.close()
            return ArrayList()
        }

        // get data from cursor
        var Album = album("", "")
        if(cursor.moveToFirst()){
            do{  // something wrong with this
                Album = album(cursor.getString(0), cursor.getString(0))

                albumList.add(Album)
            }while (cursor.moveToNext())
        }


        db.close()
        return albumList
    }


    override fun updateAlbum(album: album) {
        TODO("Not yet implemented")
    }
}
