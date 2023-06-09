package com.example.firstapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

internal class GridRVAdapter(
    private val courseList: List<String>,
    private val context: Context
) :
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var textView: TextView

    override fun getCount(): Int {
        return courseList.size
    }

    override fun getItem(position: Int): Any? {
        return courseList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gridview_item, null)
        }

        textView = convertView!!.findViewById(R.id.idTVCourse)

        textView.setText(courseList.get(position))

        if (courseList.get(position).toInt() % 2 == 0) {
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        } else {
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.blue));
        }

        return convertView
    }
}
