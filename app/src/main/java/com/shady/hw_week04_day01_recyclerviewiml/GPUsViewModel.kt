package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class GPUsViewModel : ViewModel(){

    val gpu = listOf<GPUs>(
        GPUs("RTX 3090" , "24/09/2020",true),
        GPUs("RTX 3080 Ti" , "03/06/2021",true),
        GPUs("RTX 3080" , "17/09/2020",true),
        GPUs("RTX 3070 Ti" , "10/06/2021",true),
        GPUs("RTX 3070" , "17/09/2020",true),
        GPUs("RTX 3060 Ti" , "02/12/2020",true),
        GPUs("RTX 3060" , "25/02/2021",true),
        GPUs("RTX 2080 Ti" , "27/09/2018",true),
        GPUs("RTX 2080 Super" , "09/07/2019",true),
        GPUs("TITAN RTX" , "18/12/2018",true),
        GPUs("RTX 2070 Super" , "09/07/2019",true),
        GPUs("GTX 1080 Ti" , "05/03/2017",false),
        GPUs("TITAN X" , "02/08/2016",false),
        GPUs("GTX 1080" , "20/04/2017",false),
        GPUs("GTX 1070 Ti" , "02/11/2017",false),
    )
}