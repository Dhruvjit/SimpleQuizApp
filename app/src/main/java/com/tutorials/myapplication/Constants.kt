package com.tutorials.myapplication

object Constants {
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        /* que 1 */
        val que1 = Question(
            1,
            "what country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "India",
            "Austria",
            1

        )
        questionsList.add(que1)

        /* que 2 */
        val que2 = Question(
            2,
            "what country does this flag belongs to?",
            R.drawable.ic_flag_of_india,
            "Brazil",
            "Germany",
            "India",
            "Fiji",
            3

        )
        questionsList.add(que2)
        return questionsList
    }
}