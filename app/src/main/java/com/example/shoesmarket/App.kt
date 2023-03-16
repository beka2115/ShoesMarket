package com.example.shoesmarket

import android.app.Application
import com.example.shoesmarket.repository.Repository

class App: Application() {

    val repository: Repository by lazy {
        Repository()
    }
}