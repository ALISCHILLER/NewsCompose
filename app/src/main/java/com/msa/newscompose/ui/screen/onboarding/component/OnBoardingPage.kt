package com.msa.newscompose.ui.screen.onboarding.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.msa.newscompose.ui.theme.*
import com.msa.newscompose.data.model.PageModel
import com.msa.newscompose.data.model.pagelist
import com.msa.newscompose.util.Dimens


@Composable
fun OnBoardingPage(
    modifier: Modifier=Modifier,
    page: PageModel
){
    Column(modifier=modifier){
        Image(
            modifier= Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),

            painter = painterResource(id = page.image),
            contentDescription =null
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Text(
            text = page.titie,
            modifier=Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color= Purple40
        )

        Text(
            text = page.description,
            modifier=Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color= Purple40
        )
    }

}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun OnBoardingPagePreview(){

    NewsComposeTheme {
        OnBoardingPage(page = pagelist[2])
    }
}


