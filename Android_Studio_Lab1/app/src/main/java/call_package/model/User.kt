package call_package.model

import com.example.lab1.R
data class User(
    val name: String,
    val avatar: Int,


    ) {
    companion object{
        val example = User(
            "Mahmudul Hassan",
            R.drawable.arab_man
        )
    }
}
