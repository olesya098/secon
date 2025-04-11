@file:OptIn(ExperimentalMaterial3Api::class)

package com.hfad.energon

import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hfad.energon.ui.theme.buttonColor
import com.hfad.energon.ui.theme.lable
import com.hfad.energon.ui.theme.textField
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Akts(navController: NavController) {
    var verno by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBarContent(navController, verno) { verno = it } }
    ) { paddingValues ->
        MainContent(paddingValues)
    }
}

@Composable
private fun TopAppBarContent(
    navController: NavController,
    verno: Boolean,
    onVernoChange: (Boolean) -> Unit
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackButton(navController)
                TitleText()
                AccessStatus(verno, onVernoChange)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Composable
private fun BackButton(navController: NavController) {
    Box(
        modifier = Modifier
            .background(color = textField, shape = CircleShape)
            .size(45.dp)
            .clickable { navController.navigate(Screen.SignInScreen.route) },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Назад",
            tint = Color.Black
        )
    }
}

@Composable
private fun TitleText() {
    Text(
        text = "Создание Акта",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 7.dp, end = 7.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun AccessStatus(verno: Boolean, onVernoChange: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 15.dp)
            .background(color = textField, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = if (verno) R.drawable.verno else R.drawable.close),
                contentDescription = "Статус доступа",
                modifier = Modifier
                    .clickable { onVernoChange(!verno) }
                    .size(35.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Доступ",
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun MainContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {
            WorkTypeSection()
            AddressSection()
            MeterTypeSection()
            ConsumerSection()
            MeterConditionSection()
            PhotoButtonsSection()
            WorkDescriptionSection()
            SubmitButton()
        }
    }
}

@Composable
private fun WorkTypeSection() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Выбор выполняемой работы") }
    val list = listOf(
        "отключение э/э",
        "контроль введённого ранее ограничения",
        "возобнавление э/э",
    )

    DropdownSection(
        title = "Тип выполняемой работы",
        expanded = expanded,
        selectedItem = selectedItem,
        list = list,
        onExpandedChange = { expanded = it },
        onItemSelected = { selectedItem = it }
    )
}

@Composable
private fun AddressSection() {
    var adress by remember { mutableStateOf("") }

    Text(
        text = "Адрес объекта",
        color = Color.Black,
        modifier = Modifier.padding(top = 18.dp, bottom = 8.dp),
        fontSize = 16.sp
    )
    CustomTextField(
        value = adress,
        onValueChange = { adress = it },
        label = "Полный адрес"
    )
}

@Composable
private fun MeterTypeSection() {
    var expanded2 by remember { mutableStateOf(false) }
    var expanded3 by remember { mutableStateOf(false) }
    var expanded4 by remember { mutableStateOf(false) }
    var expanded5 by remember { mutableStateOf(false) }
    var selectedItem2 by remember { mutableStateOf("Принцип действия") }
    var selectedItem3 by remember { mutableStateOf("Количество фаз") }
    var selectedItem4 by remember { mutableStateOf("Особенности тарификации") }
    var selectedItem5 by remember { mutableStateOf("Тип подключения") }
    var adress by remember { mutableStateOf("") }

    Text(
        text = "Тип и номер прибора учета",
        color = Color.Black,
        modifier = Modifier.padding(top = 18.dp, bottom = 8.dp),
        fontSize = 16.sp
    )

    DropdownSection(
        title = null,
        expanded = expanded2,
        selectedItem = selectedItem2,
        list = listOf("Индукционные", "Электронные"),
        onExpandedChange = { expanded2 = it },
        onItemSelected = { selectedItem2 = it }
    )

    DropdownSection(
        title = null,
        expanded = expanded3,
        selectedItem = selectedItem3,
        list = listOf("Однофазные", "Двухфазные", "Трёхфазные"),
        onExpandedChange = { expanded3 = it },
        onItemSelected = { selectedItem3 = it }
    )

    DropdownSection(
        title = null,
        expanded = expanded4,
        selectedItem = selectedItem4,
        list = listOf("Однотарифные", "Многотарифные"),
        onExpandedChange = { expanded4 = it },
        onItemSelected = { selectedItem4 = it }
    )

    DropdownSection(
        title = null,
        expanded = expanded5,
        selectedItem = selectedItem5,
        list = listOf("С прямым подключением", "С трансформаторным подключением"),
        onExpandedChange = { expanded5 = it },
        onItemSelected = { selectedItem5 = it }
    )

    CustomTextField(
        value = adress,
        onValueChange = { adress = it },
        label = "Номер счетчика",
        modifier = Modifier.padding(top = 18.dp)
    )
}

@Composable
private fun ConsumerSection() {
    var surname by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var secondname by remember { mutableStateOf("") }

    Text(
        text = "Потребитель",
        color = Color.Black,
        modifier = Modifier.padding(top = 18.dp, bottom = 8.dp),
        fontSize = 16.sp
    )

    CustomTextField(
        value = surname,
        onValueChange = { surname = it },
        label = "Фамилия",
        modifier = Modifier.padding(top = 12.dp)
    )

    CustomTextField(
        value = name,
        onValueChange = { name = it },
        label = "Имя",
        modifier = Modifier.padding(top = 12.dp)
    )

    CustomTextField(
        value = secondname,
        onValueChange = { secondname = it },
        label = "Отчество",
        modifier = Modifier.padding(top = 12.dp)
    )
}

@Composable
private fun MeterConditionSection() {
    var expanded6 by remember { mutableStateOf(false) }
    var expanded7 by remember { mutableStateOf(false) }
    var selectedItem6 by remember { mutableStateOf("Пломбы: целы/повреждены ") }
    var selectedItem7 by remember { mutableStateOf("Признаки вмешательства: есть/нет") }
    var description by remember { mutableStateOf("") }

    Text(
        text = "Состояние прибора",
        color = Color.Black,
        modifier = Modifier.padding(top = 18.dp, bottom = 8.dp),
        fontSize = 16.sp
    )

    DropdownSection(
        title = null,
        expanded = expanded6,
        selectedItem = selectedItem6,
        list = listOf("Целы", "Повреждены"),
        onExpandedChange = { expanded6 = it },
        onItemSelected = { selectedItem6 = it }
    )

    DropdownSection(
        title = null,
        expanded = expanded7,
        selectedItem = selectedItem7,
        list = listOf("Есть", "Нет"),
        onExpandedChange = { expanded7 = it },
        onItemSelected = { selectedItem7 = it }
    )

    CustomTextField(
        value = description,
        onValueChange = { description = it },
        label = "Видимые повреждения: описание",
        modifier = Modifier.padding(top = 18.dp)
    )
}

@Composable
private fun PhotoButtonsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, top = 25.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { /* обработка нажатия */ },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .weight(1.3f)
                .height(56.dp)
        ) {
            Text(
                text = "Сделать фото",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(modifier = Modifier.weight(0.4f).padding(start = 10.dp)) {
            IconButton(
                onClick = { /* обработка нажатия на иконку */ },
                modifier = Modifier
                    .background(buttonColor, shape = RoundedCornerShape(18.dp))
                    .size(56.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.attach_file),
                    contentDescription = "Прикрепить файл",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }

    // Исправленный Row для фото-заглушек
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PhotoPlaceholder("фото прибора до работы", Modifier.weight(1f))
        Spacer(modifier = Modifier.padding(8.dp))
        PhotoPlaceholder("фото прибора после работы", Modifier.weight(1f))
    }
}

@Composable
private fun PhotoPlaceholder(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(textField, shape = RoundedCornerShape(18.dp)),
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

    CustomTextField(
        value = descriptionwork,
        onValueChange = { descriptionwork = it },
        label = "Описание проделанной работы",
        modifier = Modifier.padding(top = 18.dp)
    )
}

@Composable
private fun SubmitButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .height(56.dp)
    ) {
        Text(
            text = "Добавить",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun DropdownSection(
    title: String?,
    expanded: Boolean,
    selectedItem: String,
    list: List<String>,
    onExpandedChange: (Boolean) -> Unit,
    onItemSelected: (String) -> Unit
) {
    title?.let {
        Text(
            text = it,
            color = Color.Black,
            fontSize = 16.sp
        )
    }

    Box {
        Box(
            modifier = Modifier
                .padding(top = if (title != null) 8.dp else 12.dp)
                .clickable { onExpandedChange(true) }
                .fillMaxWidth()
                .height(60.dp)
                .background(textField, shape = RoundedCornerShape(18.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Раскрыть список",
                    tint = lable
                )
                Text(
                    text = selectedItem,
                    color = lable,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) },
            modifier = Modifier.fillMaxWidth()
        ) {
            list.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onItemSelected(item)
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}

@Composable
private fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier.height(60.dp),
        shape = RoundedCornerShape(18.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = textField,
            unfocusedContainerColor = textField,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = lable,
            unfocusedLabelColor = lable
        )
    )
}