# RecyclerAdapterBug
This is a sample project which demonstrates a bug in the RecyclerAdapter when despite calling notifyItemChanged(0) onBindViewHolder of more items is called, not only of position 0. 

Written in Kotlin, with compileSdkVersion, minSdkVersion and targetSdkVersion = API 29
Android Studio 3.5.2
buildToolsVersion "29.0.2"
