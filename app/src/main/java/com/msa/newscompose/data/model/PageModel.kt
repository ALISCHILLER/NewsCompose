package com.msa.newscompose.data.model

import androidx.annotation.DrawableRes
import com.msa.newscompose.R

data class PageModel(
    val titie :String,
    val description:String,
    @DrawableRes val image:Int
)



val pagelist= listOf(
    PageModel(
        titie = "Loren Ipsum simply",
        description = "Lorem Ipsum is simply",
        image = R.drawable.onboarding1
    ),
    PageModel(
        titie = "Loren Ipsum simply",
        description = "Lorem Ipsum is simply",
        image = R.drawable.onboarding2
    ),
    PageModel(
        titie = "Loren Ipsum simply",
        description = "Lorem Ipsum is simply",
        image = R.drawable.onboarding3
    )

)