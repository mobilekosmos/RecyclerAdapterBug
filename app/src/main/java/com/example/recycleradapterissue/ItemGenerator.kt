package com.example.recycleradapterissue

import java.util.ArrayList

internal object ItemGenerator {

    fun largeListWithHeadersAt(): List<Item> {
        val items = ArrayList<Item>()
        for (i in 0..4) {
            items.add(Item("Item at $i", "Item description at $i", i.toLong()))
        }
        return items
    }

    fun largeListWithHeadersAt2(): List<Item> {
        val items = ArrayList<Item>()
        for (i in 0..4) {

            if (i == 0) {
                // Change ID of 0
                items.add(Item("Item at $i", "Item description at $i", (i + i).toLong()))
            } else if (i == 2) {
                // Change content and ID of 2
                items.add(Item("Item at $i updated", "Item description at $i", (i + i).toLong()))
            } else {
                // Add same item, don't change nothing
                items.add(Item("Item at $i", "Item description at $i", i.toLong()))
            }
        }
        return items
    }
}
