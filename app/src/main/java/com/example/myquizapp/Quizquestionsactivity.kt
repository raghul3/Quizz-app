package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Quizquestionsactivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int=1
    private var mQuestionsList: ArrayList<Questions>?=null
    private var mSelectedOptionPosition:Int=0
    private var mUserName : String?=null
    private var mCorretAnswers : Int=0



    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestions: TextView? =null
    private var ivImage:ImageView?=null

    private var tvOptionOne:TextView?=null
    private var tvOptiontwo:TextView?=null
    private var tvOptionthree:TextView?=null
    private var tvOptionfour:TextView?=null
    private var btnSubmit: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestionsactivity)

        mUserName = intent.getStringExtra(constants.USER_NAME)



        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestions= findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptiontwo=findViewById(R.id.tv_option_two)
        tvOptionthree=findViewById(R.id.tv_option_three)
        tvOptionfour=findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)
        tvOptionOne?.setOnClickListener(this)
        tvOptiontwo?.setOnClickListener(this)
        tvOptionthree?.setOnClickListener(this)
        tvOptionfour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener (this)



        mQuestionsList = constants.getQuestions()




        setQuestion()

    }

    private fun setQuestion() {


        val question: Questions = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestions?.text = question.question
        tvOptionOne?.text = question.optionone
        tvOptiontwo?.text = question.optiontwo
        tvOptionthree?.text = question.optionthree
        tvOptionfour?.text = question.optionfour

        if(mCurrentPosition==mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"

        }else{
            btnSubmit?.text="SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptiontwo?.let{
            options.add(1,it)
        }
        tvOptionthree?.let{
            options.add(2,it)
        }
        tvOptionfour?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor((Color.parseColor("#7A8089")))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )


        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){
        defaultOptionsView()


        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_optio_bg
        )


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option_two -> {
                tvOptiontwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_three -> {
                tvOptionthree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_four -> {
                tvOptionfour?.let {
                    selectedOptionView(it, 4)
                }


            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this,resultactivity::class.java)
                            intent.putExtra(constants.USER_NAME,mUserName)
                            intent.putExtra(constants.CORRECT_ANSWERS,mCorretAnswers)
                            intent.putExtra(constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()


                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctanswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    }else{
                        mCorretAnswers++
                    }
                    answerView(question.correctanswer, R.drawable.correct_option_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        btnSubmit?.text="FINISH"

                    }else{
                        btnSubmit?.text="GO TO NEXT QUESTION"

                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }
    private fun answerView(answer: Int,drawableView: Int){
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this@Quizquestionsactivity,
                    drawableView
                )
            }
            3->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this@Quizquestionsactivity,
                    drawableView
                )
            }
            4->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this@Quizquestionsactivity,
                    drawableView
                )
            }
        }
    }
}