package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val movie = Movie("The Queens Gambit", "Drama, Sport", "Anya Taylor-Joy, Chloe Pirrie", "Scott Frank, Alan Scott",
            "The Queen\\'s Gambit follows the life of an orphan chess prodigy, Elizabeth Harmon, during her quest to become the world\\'s greatest chess player while struggling with emotional problems and drug and alcohol dependency. The title of the series refers to a chess opening of the same name. The story begins in the mid-1950s and proceeds into the 1960s.[4]\n" +
                "The story begins in Lexington, Kentucky, where a nine-year-old Beth, having lost her mother in a car crash, is taken to an orphanage where she is taught chess by the building\\'s custodian, Mr. Shaibel. As was common during the 1950s, the orphanage dispenses daily tranquilizer pills to the girls,[5][6] which turns into an addiction for Beth. She quickly becomes a strong chess player due to her visualization skills, which are enhanced by the tranquilizers. A few years later, Beth is adopted by Alma Wheatley and her husband from Lexington. As she adjusts to her new home, Beth enters a chess tournament and wins despite having no prior experience in competitive chess. She develops friendships with several people, including former Kentucky State Champion Harry Beltik, United States National Champion Benny Watts, and journalist and fellow player D.L. Townes. As Beth rises to the top of the chess world and reaps the financial benefits of her success, her drug and alcohol dependency becomes worse.\n")
        bind.movie = movie;

        val btn: FloatingActionButton = findViewById(R.id.addButton)
        btn.setOnClickListener {
            Toast.makeText(this, "Bookmarked Movie", Toast.LENGTH_LONG).show()
        }

    }
}