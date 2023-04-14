package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class databaseHandler(context: Context):SQLiteOpenHelper(context, DATABASENAME, null, DATABASEVERSION){
    companion object{
        private val DATABASEVERSION =1
        private val DATABASENAME = "AlbumDatabase"


        const val tableAlbum = "table_album"
        const val tableAlbumId ="album_id"
        const val tableAlbumName = "album_name"
        const val tableAlbumArtist = "album_artist"
        const val tableAlbumRelease = "album_release"
        const val tableAlbumLabel = "album_label"
        const val tableAlbumDesc ="album_desc"
    }

    override fun onCreate(db: SQLiteDatabase?){
        val CREATEALBUMTABLE =
            "CREATE TABLE $tableAlbum " +
                    "($tableAlbumId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$tableAlbumName TEXT, " +
                    "$tableAlbumArtist TEXT, " +
                    "$tableAlbumRelease TEXT, " +
                    "$tableAlbumLabel TEXT, " +
                    "$tableAlbumDesc TEXT)"
        db?.execSQL(CREATEALBUMTABLE)

        db?.execSQL("Insert into $tableAlbum ($tableAlbumName, $tableAlbumArtist) values('Plastic Beach', 'Gorillaz');")
        db?.execSQL("Insert into $tableAlbum ($tableAlbumName, $tableAlbumArtist) values('Fearless', 'Taylor Swift');")
        db?.execSQL("Insert into $tableAlbum ($tableAlbumName, $tableAlbumArtist) values('Divide', 'Ed Sheeran');")

    }
    // p1 is old version and p2 is new version
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableAlbum")
        onCreate(db)
    }

}