package au.edu.swin.sdmd.l04_moreimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources

const val KEY_IMAGE = "image_key"

class MainActivity : AppCompatActivity() {

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE", "stopped")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageView)

        /**
         * This is the code to restore the state.
         *
         * The override function onRestoreInstanceState can also be used, however
         * this is called at a different point in the lifecycle.
         */
        savedInstanceState?.let {
            image.contentDescription = it.getString(KEY_IMAGE)

            image.apply {
                when (contentDescription) {
                    "station" -> setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.station
                        )
                    )
                    "college" -> setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.college
                        )
                    )
                    "theatre" -> setImageDrawable(
                        AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.theatre
                        )
                    )
                }
            }
            Log.i("LIFECYCLE", "onRestoreInstanceState")
        }


        val station = findViewById<Button>(R.id.station)
        station.setOnClickListener {
            image.setImageDrawable(
                AppCompatResources.getDrawable(applicationContext, R.drawable.station))
            image.contentDescription = "station"
        }

        val onClickTheatre = View.OnClickListener {
            image.setImageDrawable(
                AppCompatResources.getDrawable(applicationContext, R.drawable.theatre))
            image.contentDescription = "theatre"
        }

        val theatre = findViewById<Button>(R.id.theatre)
        theatre.setOnClickListener(onClickTheatre)
    }


    /**
     * This is needed to save state. The variables to save need to be
     * added to a Bundle with a key, in this case "image".
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val image = findViewById<ImageView>(R.id.imageView)
        outState.putString(KEY_IMAGE, image.contentDescription.toString())

        Log.i("LIFECYCLE", "onSaveInstanceState")
    }



    fun onClickCollege(v: View) {
        val image = findViewById<ImageView>(R.id.imageView)
        image.setImageDrawable(
            AppCompatResources.getDrawable(applicationContext, R.drawable.college))
        image.contentDescription = "college"
    }

}