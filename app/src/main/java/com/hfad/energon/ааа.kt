@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hackaton.features.create_act.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.energon.MainButton
import com.hfad.energon.MainTextField
import com.hfad.energon.R
import com.hfad.energon.ui.theme.buttonColor
import com.hfad.energon.ui.theme.lable
import com.hfad.energon.ui.theme.red
import com.hfad.energon.ui.theme.textField

@Composable
fun CreateActScreen() {
    Content()
}

@Composable
private fun TopAppBarContent(
    onBackButtonClick: () -> Unit,
) {
    var success by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = "Акт №1",
                color = Color.Black,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 7.dp, end = 7.dp),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackButtonClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(247, 247, 249),
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        },
        actions = {
            Row(
                modifier = Modifier
                    .clickable { success = !success }
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(247, 247, 249))
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(if (success) R.drawable.verno else R.drawable.close),
                    contentDescription = "Статус доступа",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Доступ",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Composable
private fun Content() {
    Scaffold(
        topBar = {
            TopAppBarContent(
                onBackButtonClick = { }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CheckBoxActLimit()
            CheckBoxActRestart()
            DataContract()
            AddressSection()
            ConsumerSection()
            SwitchingDevice()
            LimitationElectricity()
            PowerSupply()
            MeterTypeSection()
            ReadingTag()
            MeterConditionSection()
            Painting()
            PaintingProfile()
            PhotoButtonsSection()

            WorkDescriptionSection()
            MainButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                text = "Закрыть адрес"
            )
        }
    }
}

@Composable
private fun CheckBoxActLimit(
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit = {},
    initialChecked: Boolean = false
) {
    var isChecked by remember { mutableStateOf(initialChecked) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { isChecked = !isChecked },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                onCheckedChange(it)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = buttonColor,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            ),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = "О введении ограничения комунальной услуги",
            fontSize = 16.sp,
            color = if (isChecked) Color.Black else Color.Gray,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
private fun CheckBoxActRestart(
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit = {},
    initialChecked: Boolean = false
) {
    var isChecked2 by remember { mutableStateOf(initialChecked) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { isChecked2 = !isChecked2 },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked2,
            onCheckedChange = {
                isChecked2 = it
                onCheckedChange(it)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = buttonColor,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            ),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = "О возобновлении предоставления комунальной услуги",
            fontSize = 16.sp,
            color = if (isChecked2) Color.Black else Color.Gray,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
private fun DataContract() {
    var data by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Дата и время составления акта",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        MainTextField(
            value = data,
            onValueChange = { data = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Дата [11.04.2025]") }
        )
        MainTextField(
            value = time,
            onValueChange = { time = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Время [11:10]") }
        )
    }
}


@Composable
private fun AddressSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Адрес объекта (место составления акта)",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Locality()
        Street()
        Home()
        Flat()
        Room()

    }
}

@Composable
private fun Locality() {
    var locality by remember { mutableStateOf("") }
    MainTextField(
        value = locality,
        onValueChange = { locality = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Населенный пункт") }
    )
}

@Composable
private fun Street() {
    var street by remember { mutableStateOf("") }
    MainTextField(
        value = street,
        onValueChange = { street = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Улица") }
    )
}

@Composable
private fun Home() {
    var home by remember { mutableStateOf("") }
    MainTextField(
        value = home,
        onValueChange = { home = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Дом") }
    )
}

@Composable
private fun Flat() {
    var flat by remember { mutableStateOf("") }
    MainTextField(
        value = flat,
        onValueChange = { flat = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Квартира") }
    )
}

@Composable
private fun Room() {
    var room by remember { mutableStateOf("") }
    MainTextField(
        value = room,
        onValueChange = { room = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Комната") }
    )
}

@Composable
private fun MeterTypeSection() {
    var tagType by remember { mutableStateOf("") }
    var tagNumber by remember { mutableStateOf("") }
    var other by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Тип и номер прибора учета",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            MainTextField(
                value = tagType,
                onValueChange = { tagType = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Тип счетчика") }
            )
            MainTextField(
                value = tagNumber,
                onValueChange = { tagNumber = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Номер счетчика") }
            )
            DropdownBox(
                title = "Место установки пр. учета",
                items = listOf("В квартире", "На лестнечной площадке", "Другое")
            )
            MainTextField(
                value = other,
                onValueChange = { other = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Другое место:") }
            )
        }
    }
}

@Composable
private fun ReadingTag() {
    var moment by remember { mutableStateOf("") }
    var pleace by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Показания прибора",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            MainTextField(
                value = moment,
                onValueChange = { moment = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "На момент проведения работ") }
            )
            MainTextField(
                value = pleace,
                onValueChange = { pleace = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Место установки пломб") }
            )
        }
    }
}

@Composable
private fun ConsumerSection() {
    var surname by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var secondname by remember { mutableStateOf("") }
    var personalaccount by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Потребитель",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MainTextField(
                value = surname,
                onValueChange = { surname = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Фамилия") }
            )
            MainTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Имя") }
            )
            MainTextField(
                value = secondname,
                onValueChange = { secondname = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Отчество") }
            )
            MainTextField(
                value = personalaccount,
                onValueChange = { personalaccount = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Лицевой счет №") }
            )
            MainTextField(
                value = phone,
                onValueChange = { phone = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Тел. Потребителя") }
            )
        }
    }
}

@Composable
private fun SwitchingDevice() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Коммутационный (вводной) аппарат",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        DropdownBox(
            title = "имеется/отсутствует",
            items = listOf("Имеется", "Отсутствует")
        )
    }
}

@Composable
private fun LimitationElectricity() {
    var selected by remember { mutableStateOf(false) }
    var other by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Основание введения ограничения потребления",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = textField,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .clickable { selected = !selected },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Неполная оплата коммунальной услуги",
                color = lable,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )

            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = if (selected) R.drawable.verno else R.drawable.close
                    ),
                    contentDescription = if (selected) "Выбрано" else "Не выбрано",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        MainTextField(
            value = other,
            onValueChange = { other = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Другие причины") }
        )
    }
}

@Composable
private fun PowerSupply() {
    var data by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var method by remember { mutableStateOf("") }
    var sealNumber by remember { mutableStateOf("") }
    var pleaceInstall by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Подача электроэнергии",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DropdownBox(
                title = "Огранич./Приост./Возобн.",
                items = listOf("Ограничена", "Приостановлена", "Возобновлена")
            )
            MainTextField(
                value = data,
                onValueChange = { data = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Дата [11.04.2025]") }
            )
            MainTextField(
                value = time,
                onValueChange = { time = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Время [11:10]") }
            )
            DropdownBox(
                title = "Потреб./Испол.",
                items = listOf("Ограничена", "Приостановлена", "Возобновлена")
            )
            MainTextField(
                value = method,
                onValueChange = { method = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Cпособ введения огр./приост./возобновл. ") }
            )
            MainTextField(
                value = sealNumber,
                onValueChange = { sealNumber = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Номер пломб") }
            )
            MainTextField(
                value = pleaceInstall,
                onValueChange = { pleaceInstall = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Место установки пломб") }
            )

        }
    }
}

@Composable
private fun MeterConditionSection() {
    var description by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Состояние прибора",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DropdownBox(
                title = "Пломбы: целы/повреждены",
                items = listOf("Целы", "Повреждены")
            )
            DropdownBox(
                title = "Признаки вмешательства: есть/нет",
                items = listOf("Есть", "Нет")
            )
            MainTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Видимые повреждения: описание") },
            )
        }
    }
}

@Composable
private fun Painting() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PaintingInside("подпись 1 инспектора", Modifier.weight(1f))
        PaintingInside("подпись 2 инспектора", Modifier.weight(1f))
    }
}

@Composable
private fun PaintingInside(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth()
            .drawWithContent {
                drawContent()
                drawRoundRect(
                    color = Color(0xFF7B7B7B),
                    cornerRadius = CornerRadius(18.dp.toPx()),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 5f), 0f)
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}
@Composable
private fun PaintingProfile() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PaintingInsideProfile("подпись потребителя", Modifier.weight(1f))
        PaintingInsideProfile(
            "отказался от подписи",
            Modifier.weight(1f),
            borderColor = red,
            textColor = red
        )
    }
}

@Composable
private fun PaintingInsideProfile(
    text: String,
    modifier: Modifier = Modifier,
    borderColor: Color = Color(0xFF7B7B7B),
    textColor: Color = Color.Black
) {
    Box(
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth()
            .drawWithContent {
                drawContent()
                drawRoundRect(
                    color = borderColor, // Используем переданный цвет границы
                    cornerRadius = CornerRadius(18.dp.toPx()),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 5f), 0f)
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor, // Используем переданный цвет текста
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun PhotoButtonsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MainButton(
            onClick = { },
            modifier = Modifier.weight(1f),
            text = "Выбрать из галереи"
        )

    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PhotoPlaceholder("фото прибора до работы", Modifier.weight(1f))
        PhotoPlaceholder("фото прибора после работы", Modifier.weight(1f))
    }
}

@Composable
private fun PhotoPlaceholder(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .drawWithContent {
                drawContent()
                drawRoundRect(
                    color = Color(0xFF7B7B7B),
                    cornerRadius = CornerRadius(18.dp.toPx()),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 5f), 0f)
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun WorkDescriptionSection() {
    var descriptionwork by remember { mutableStateOf("") }

    MainTextField(
        value = descriptionwork,
        onValueChange = { descriptionwork = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Описание работы") }
    )
}

@Composable
private fun DropdownBox(
    title: String,
    items: List<String>
) {
    var value by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier.fillMaxWidth()
    ) {
        MainTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .menuAnchor(),
            enabled = false,
            placeholder = { Text(text = title) },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded)
                        Icons.Default.KeyboardArrowUp
                    else
                        Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color(0xFF6A6A6A)
                )
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            fontSize = 16.sp
                        )
                    },
                    onClick = { value = item },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
@Preview
fun CreateActScreenPreview() {
    Content()
}