package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsRecycleViewActivity : AppCompatActivity() {
    val adapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_news)

        val recycler = findViewById<RecyclerView>(R.id.news_recycler)

        // Сообщаем RecyclerView, откуда брать информацию об элементах
        recycler.adapter = adapter
        // Сообщаем RecyclerView, каким образом отрисовывать элементы
        recycler.layoutManager = LinearLayoutManager(this)

        // Создаём список элементов
        val posts = MutableList(15) {
            if (it % 2 == 0) {
                Post(
                    icon = R.drawable.cat,
                    name = "Tom",
                    text = "Hi! I'm your neighbour. Do you like my avatar?",
                    picture = R.drawable.cat
                )
            }
            else if (it % 3 == 0){
                Post(
                    icon = R.drawable.girl,
                    name = "Mary",
                    text = "Hello! It's a random letters feyfrchbskdbl,vsl;omv;ewjvjislmsk;endvenvend"
                )
            }
            else{
                Post(
                    icon = R.drawable.boy,
                    name = "Jake",
                    text = "Oh no! I don't know how to writehkvgbhbhkutvfrtudserxgc hjblbuhnu;ihlgbhyujgtbfvdsasdfghjnmk"
                )
            }
        }
        // Передаём нужные элементы в адаптер
        adapter.setItems(posts)
    }
}