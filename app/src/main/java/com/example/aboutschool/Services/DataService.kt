package com.example.aboutschool.Services

import com.example.aboutschool.Models.DepartmentGroup

object DataService {
    val groups = listOf(
        DepartmentGroup("五穀", "img_various_grains"),
        DepartmentGroup("蔬菜", "img_vegetables"),
        DepartmentGroup("水果", "img_fruits")
    )
}