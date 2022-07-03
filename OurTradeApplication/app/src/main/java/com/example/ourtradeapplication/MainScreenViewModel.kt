package com.example.ourtradeapplication

import androidx.lifecycle.ViewModel
import java.util.*

class MainScreenViewModel : ViewModel() {
    companion object {
        val months = listOf(
            "янв.",
            "фев.",
            "мар.",
            "апр.",
            "май.",
            "июн.",
            "июл.",
            "авг.",
            "сен.",
            "окт.",
            "ноя.",
            "дек."
        )
        val names = listOf(
            "доски",
            "краска",
            "стяжка",
            "инструмент",
            "шифер",
            "шлакоблоки",
            "щебень",
            "песок",
            "цемент",
            "обои"
        )
        val owners = listOf(
            "Иванов И.И.",
            "Григорьев Г.Г.",
            "Чижов Ч.Ч.",
            "Андреев А.А.",
            "Кабнчиков К.К.",
            "Синий С.С.",
            "Черный Ч.Ч.",
            "Жориков Ж.Ж.",
            "Смелый В.И.",
            "Картошкин Л.У."
        )
    }


    open class GoodModel(
            var cost:Int = 0,
            var time:Date = Date(),
            var name:String = "",
            var owner:String = "",
            var id:Int = 0
    )
}