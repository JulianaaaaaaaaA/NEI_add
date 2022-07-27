package com.ksivanova.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.ksivanova.news.R

// Класс, сообщающий RecyclerView, сколько данных есть, какие вью создавать и как их обновлять
class NewsAdapter: RecyclerView.Adapter<MessageViewHolder>() {
    private var items = listOf<Post>()

    // Обновляем данные
    fun setItems(posts: List<Post>) {
        items = posts
        // Говорим RecyclerView, что нужно обновить содержимое
        notifyDataSetChanged()
    }

    // Отдаём RecyclerView вью, которое мы хотим использовать для отрисовки
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        // Создаём view, указав xml файл элемента
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return MessageViewHolder(view)
    }

    // Обновляем состояние вью для нового Message
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        // По полученной позиции получаем нужный элемент Message
        val message = items[position]
        // Отрисовываем нужные данные во вью
        holder.bind(message)
    }

    // Возвращаем RecyclerView актуальное количество элементов
    override fun getItemCount(): Int {
        return items.size
    }

}

// Класс, отвечающий за отрисовку данных из Message
class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Запоминаем ссылки на нужные элементы
    private val icon = itemView.findViewById<ImageView>(R.id.user_icon)
    private val name = itemView.findViewById<TextView>(R.id.user_name)
    private val text = itemView.findViewById<TextView>(R.id.user_text)
    private val picture = itemView.findViewById<ImageView>(R.id.user_picture)

    // Проставляем данные из конкретного Message во вью
    fun bind(post: Post) {
        icon.setImageResource(post.icon)
        name.text = post.name
        text.text = post.text
        if(picture != null){
            post.picture?.let { picture.setImageResource(it) }
        }
        else{
            picture?.visibility = View.GONE
        }
    }
}

// Класс, хранящий в себе отображаемую информацию
data class Post(@DrawableRes val icon: Int, val name: String, val text: String, val picture: Int? = null)