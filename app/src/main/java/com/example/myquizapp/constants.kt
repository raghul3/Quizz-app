package com.example.myquizapp

object constants {

    const val USER_NAME : String = "User_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String ="correct_answers"

    fun getQuestions():ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1,"what Country does this flag belong to?",R.drawable.ic_india,"Argentina","India",
            "Brazil","Qatar",2
        )
        questionsList.add(que1)

        val que2 = Questions(
            2,"what Country does this flag belong to?",R.drawable.ic_argentina,"Argentina","India",
            "Brazil","Qatar",1
        )
        questionsList.add(que2)




        val que3 = Questions(
            3,"what Country does this flag belong to?",R.drawable.ic_brazil,"France","India",
            "Brazil","Qatar",3
        )
        questionsList.add(que3)

        val que4 = Questions(
            4,"what Country does this flag belong to?",R.drawable.ic_france,"Argentina","India",
            "France","Austria",3
        )
        questionsList.add(que4)

        val que5 = Questions(
            5,"what Country does this flag belong to?",R.drawable.ic_england,"Ecuador","India",
            "Brazil","England",4
        )
        questionsList.add(que5)

        val que6 = Questions(
            6,"what Country does this flag belong to?",R.drawable.ic_belgium,"Argentina","Belgium",
            "Australia","Qatar",2
        )
        questionsList.add(que6)

        val que7 = Questions(
            7,"what Country does this flag belong to?",R.drawable.ic_ghana,"Argentina","India",
            "Brazil","Ghana",4
        )
        questionsList.add(que7)

        val que8 = Questions(
            8,"what Country does this flag belong to?",R.drawable.ic_morocco,"Morocco","Spain",
            "Turkey","Australia",1
        )
        questionsList.add(que8)

        val que9 = Questions(
            9,"what Country does this flag belong to?",R.drawable.ic_netherlands,"Germany","Finland",
            "Netherlands","USA",3
        )
        questionsList.add(que9)

        val que10 = Questions(
            10,"what Country does this flag belong to?",R.drawable.ic_italy,"Turkey","India",
            "Russia","Italy",4
        )
        questionsList.add(que10)








        return questionsList

    }
}