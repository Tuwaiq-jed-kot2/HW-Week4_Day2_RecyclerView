package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class QuoteViewModel:ViewModel() {

            var quotes = listOf(
                Quote("\"And now that you don't have to be perfect, you can be good.\"", "John Steinbeck"),
                Quote("\"Everything is hard before it is easy.\"", "Johann Wolfgang von Goethe"),
                Quote("\"Anyone who has never made a mistake has never tried anything new.\"", "Albert Einstein"),
                Quote("\"Don't let your happiness depend on something you may lose.\"", "C.S. Lewis"),
                Quote("\"Some of us think holding on makes us strong; but sometimes it is letting go.\" ","Herman Hesse"),
                Quote("\"Never look back unless you are planning to go that way.\"","Henry David Thoreau"),
                Quote("\"Sooner or later even the fastest runners have to stand and fight.\"","Stephen King"),
                Quote("\"We rise by lifting others.\" ","Robert Ingersoll"),
                Quote("\"Life is a journey, not a destination.\"","Ralph Waldo Emerson"),
                Quote("\"As you start to walk on the way, the way appears.\" ","Rumi"),
                Quote("\"It takes a great deal of courage to see the world in all its tainted glory, and still love it.\"","Oscar Wilde"),
                Quote("\"Straight roads do not make skillful drivers.\"","Paula Coelho"),
                Quote("\"When you can't change the direction of the wind, adjust your sails.\"","H. Jackson Brown Jr."),
                Quote("\"Life is tough my darling, but so are you.\"","Stephanie Bennett Henry"),
                Quote("\"A bad day doesn’t cancel out a good life. Keep going.\"","Richie Norton"))


}