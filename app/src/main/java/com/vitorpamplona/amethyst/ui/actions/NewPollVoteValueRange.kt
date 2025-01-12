package com.vitorpamplona.amethyst.ui.actions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorpamplona.amethyst.R
import com.vitorpamplona.amethyst.ui.theme.DoubleHorzSpacer
import com.vitorpamplona.amethyst.ui.theme.placeholderText

@Composable
fun NewPollVoteValueRange(pollViewModel: NewPostViewModel) {
    val colorInValid = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = MaterialTheme.colors.error,
        unfocusedBorderColor = Color.Red
    )
    val colorValid = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = MaterialTheme.colors.primary,
        unfocusedBorderColor = MaterialTheme.colors.placeholderText
    )

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = pollViewModel.valueMinimum?.toString() ?: "",
            onValueChange = { pollViewModel.updateMinZapAmountForPoll(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f),
            colors = if (pollViewModel.isValidvalueMinimum.value) colorValid else colorInValid,
            label = {
                Text(
                    text = stringResource(R.string.poll_zap_value_min),
                    color = MaterialTheme.colors.placeholderText
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.sats),
                    color = MaterialTheme.colors.placeholderText
                )
            }
        )

        Spacer(modifier = DoubleHorzSpacer)

        OutlinedTextField(
            value = pollViewModel.valueMaximum?.toString() ?: "",
            onValueChange = { pollViewModel.updateMaxZapAmountForPoll(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f),
            colors = if (pollViewModel.isValidvalueMaximum.value) colorValid else colorInValid,
            label = {
                Text(
                    text = stringResource(R.string.poll_zap_value_max),
                    color = MaterialTheme.colors.placeholderText
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.sats),
                    color = MaterialTheme.colors.placeholderText
                )
            }
        )
    }

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.poll_zap_value_min_max_explainer),
            color = MaterialTheme.colors.placeholderText,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}

@Preview
@Composable
fun NewPollVoteValueRangePreview() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        NewPollVoteValueRange(NewPostViewModel())
    }
}
