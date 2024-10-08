package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.avatars.ProfileAvatar
import ru.wb.ui.ui.component.avatars.ProfileSize
import ru.wb.ui.ui.component.chips.SocialChips
import ru.wb.ui.ui.component.utils.Constants.PADDING_CHIPS_GROUP_PROFILE_SCREEN
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_AVATAR_PROFILE_SCREEN
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_TEXT_BLOCK_PROFILE_SCREEN
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ProfileViewCard(
    userData: UserData,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            ProfileAvatar(
                modifier = Modifier.padding(top = VERTICAL_PADDING_AVATAR_PROFILE_SCREEN.dp),
                size = ProfileSize.LARGE
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = VERTICAL_PADDING_TEXT_BLOCK_PROFILE_SCREEN.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier,
                    text = userData.firstName + userData.lastName,
                    style = AppTheme.typography.heading3.copy(textAlign = TextAlign.Center)
                )
                Text(
                    modifier = Modifier,
                    text = userData.phone,
                    style = AppTheme.typography.subheading2.copy(textAlign = TextAlign.Center),
                    color = AppTheme.colors.neutralColorDisabled
                )
            }

            SocialChips(
                modifier = Modifier.padding(PADDING_CHIPS_GROUP_PROFILE_SCREEN.dp),
                list = userData.socialMedia
            )
        }
    }
}