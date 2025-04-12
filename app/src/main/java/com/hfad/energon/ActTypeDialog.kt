package com.hfad.energon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.hfad.energon.ui.theme.lable
@Composable
fun ActTypeDialog(
    onDismissRequest: () -> Unit,
    onControlSelected: () -> Unit,
    onMobileSmartwaySelected: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        DialogContent(
            onDismissRequest = onDismissRequest,
            onControlSelected = onControlSelected,
            onMobileSmartwaySelected = onMobileSmartwaySelected
        )
    }
}

@Composable
private fun DialogContent(
    onDismissRequest: () -> Unit,
    onControlSelected: () -> Unit,
    onMobileSmartwaySelected: () -> Unit
) {
    Column(
        modifier = Modifier.dialogModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DialogHeader(onDismissRequest)
        DialogDivider()
        ControlOption(onControlSelected, onDismissRequest)
        DialogDivider()
        MobileSmartwayOption(onMobileSmartwaySelected, onDismissRequest)
    }
}

@Composable
private fun DialogHeader(onDismissRequest: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(onDismissRequest)
        DialogTitle()
    }
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.padding(end = 8.dp),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color(247, 247, 249),
            contentColor = Color.Black
        )
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Назад"
        )
    }
}

@Composable
private fun DialogTitle() {
    Text(
        text = "ВЫБОР ТИПА АКТА",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun DialogDivider() {
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    )
}

@Composable
private fun ControlOption(
    onSelected: () -> Unit,
    onDismiss: () -> Unit
) {
    DialogOption(
        text = "Контроль",
        onClick = {
            onSelected()
            onDismiss()
        }
    )
}

@Composable
private fun MobileSmartwayOption(
    onSelected: () -> Unit,
    onDismiss: () -> Unit
) {
    DialogOption(
        text = "Ограничение/Возобновление",
        onClick = {
            onSelected()
            onDismiss()
        }
    )
}

@Composable
private fun DialogOption(
    text: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

private fun Modifier.dialogModifier(): Modifier = this
    .fillMaxWidth(0.9f)
    .background(Color.White, RoundedCornerShape(16.dp))
    .padding(horizontal = 24.dp, vertical = 16.dp)